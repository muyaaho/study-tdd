package test.java.chap03;

import java.time.LocalDate;

public class PayData {
    private LocalDate billingDate;
    private int payAmount;

    private PayData() {
    }

    public PayData(LocalDate billingDate, int payAmount) {
        this.billingDate = billingDate;
        this.payAmount = payAmount;
    }

    public LocalDate getBillingDate() {
        return billingDate;
    }

    public int getPayAmount() {
        return payAmount;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private PayData data = new PayData();

        /* 이펙티브 자바: 생성자에 매개변수가 많다면 빌더를 고려하라
         * 패턴 중 하나(빌더 패턴)*/
        public Builder billingDate(LocalDate billingDate) {
            data.billingDate = billingDate;
            return this;
        }

        public Builder payAmount(int payAmount) {
            data.payAmount = payAmount;
            return this;
        }

        public PayData build() {
            return data;
        }
    }
}
