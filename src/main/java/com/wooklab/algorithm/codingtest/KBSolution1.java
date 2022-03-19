package com.wooklab.algorithm.codingtest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Stack;

// solved..
public class KBSolution1 {

    private static final String BASIC_DATE = "2022";
    private static final String FINAL_DATE = BASIC_DATE + "-12-31";

    public static void main(String[] args) {
        KBSolution1 m = new KBSolution1();

        System.out.println(m.solution(new String[]{"01/01 4 50000",
                                                   "01/11 6 3555",
                                                   "02/01 0 -23555",
                                                   "02/25 5 5000",
                                                   "03/25 0 -15000",
                                                   "06/09 8 43951",
                                                   "12/30 9 99999"}));
        System.out.println(m.solution(new String[]{"04/01 1 40000",
                                                   "05/01 5 20000",
                                                   "08/31 4 10000",
                                                   "11/11 0 -45000"}));
    }

    public int solution(String[] ledgers) {
        int answer = 0;
        Stack<Assets> assetHistory = new Stack<>();
        for (String ledger : ledgers) {
            Assets assets = Assets.create(ledger);
            if (AssetType.DEPOSIT == assets.getAssetType()) {
                assetHistory.push(assets);
            } else {
                answer += calculateWithdraw(assetHistory, assets);
            }
        }

        if (!assetHistory.isEmpty()) {
            answer += calculateRemainDeposit(assetHistory);
        }

        return answer;
    }

    private int calculateWithdraw(Stack<Assets> assetHistory, Assets assets) {
        int interestPrice = 0;
        Assets withdrawAssets = assets;
        while (!assetHistory.isEmpty()) {
            Assets preAssets = assetHistory.pop();
            WithdrawResult result = withdrawAssets.calculateInterestPriceWith(preAssets);

            interestPrice += result.getInterestPrice();
            if (result.getSubPrice() == 0) {
                break;
            } else if (result.getSubPrice() > 0) {
                assetHistory.push(Assets.create(preAssets, result.getSubPrice()));
                break;
            } else {
                withdrawAssets = Assets.create(withdrawAssets, result.getSubPrice());
            }
        }
        return interestPrice;
    }


    private int calculateRemainDeposit(Stack<Assets> assetHistory) {
        int interestPrice = 0;
        while (!assetHistory.isEmpty()) {
            Assets assets = assetHistory.pop();
            interestPrice += assets.calculateInterestPrice(LocalDate.parse(FINAL_DATE));
        }
        return interestPrice;
    }

    static class Assets {

        private final LocalDate depositDate;
        private final int interestRate;
        private final int price;
        private final AssetType assetType;

        private Assets(LocalDate depositDateTime, int interestRate, int price) {
            this.depositDate = depositDateTime;
            this.interestRate = interestRate;
            this.price = Math.abs(price);
            this.assetType = price > 0 ? AssetType.DEPOSIT : AssetType.WITHDRAW;
        }

        public static Assets create(String ledgerAsString) {
            String[] temp = ledgerAsString.split(" ");
            String defaultYear = "2022";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            return new Assets(LocalDate.parse(defaultYear + "/" + temp[0], formatter),
                              Integer.parseInt(temp[1]),
                              Integer.parseInt(temp[2])
            );
        }

        public static Assets create(Assets copyAssets, int remainDepositPrice) {
            return new Assets(copyAssets.getDepositDate(),
                              copyAssets.getInterestRate(),
                              remainDepositPrice);
        }

        public LocalDate getDepositDate() {
            return depositDate;
        }

        public int getInterestRate() {
            return interestRate;
        }

        public int getPrice() {
            return price;
        }

        public AssetType getAssetType() {
            return assetType;
        }

        public int calculateInterestPrice(LocalDate withdrawDate) {
            return calculateInterestPrice(withdrawDate, 0);
        }

        public int calculateInterestPrice(LocalDate withdrawDate, int subPrice) {
            int depositDays = (int) ChronoUnit.DAYS.between(depositDate, withdrawDate);
            return (int) Math.floor((float) (price - subPrice) * interestRate / 100 / 365 * depositDays);
        }

        public WithdrawResult calculateInterestPriceWith(Assets preAssets) {
            int subPrice = preAssets.getPrice() - price;
            int interestPrice;
            if (subPrice > 0) {
                interestPrice = preAssets.calculateInterestPrice(depositDate, subPrice);
            } else {
                interestPrice = preAssets.calculateInterestPrice(depositDate);
            }
            return new WithdrawResult(interestPrice, subPrice);
        }

        @Override
        public String toString() {
            return "Assets{" +
                "depositDateTime=" + depositDate +
                ", interest=" + interestRate +
                ", price=" + price +
                ", assetType=" + assetType +
                '}';
        }
    }

    static class WithdrawResult {

        private final int interestPrice;
        private final int subPrice;

        public WithdrawResult(int interestPrice, int subPrice) {
            this.interestPrice = interestPrice;
            this.subPrice = subPrice;
        }

        public int getInterestPrice() {
            return interestPrice;
        }

        public int getSubPrice() {
            return subPrice;
        }
    }

    enum AssetType {
        DEPOSIT, WITHDRAW
    }

}
