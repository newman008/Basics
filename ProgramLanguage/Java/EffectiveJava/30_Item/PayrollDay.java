// strategy enum type
public enum PayrollDay {
    MONDAY(PayType.WEEKDAY),
    TUESDAY(PayType.WEEKDAY),
    WEDNEDSAY(PayType.WEEKDAY),
    THURSDAY(PayType.WEEKDAY),
    FRIDAY(PayType.WEEKDAY),
    SATURDAY(PayType.WEEKEND),
    SUNDAY(PayType.WEEKEND);

    private final PayType payType;
    PayrollDay(PayType payType) {
        this.payType = payType;
    }

    double pay(double hrs, double payRate) {
        return payType.pay(hrs, payRate);
    }

    private enum PayType {
        WEEKDAY {
            double overtimePay(double hrs, double payRate) {
                return hrs <= 8 ? 0 : (hrs - 8) * payRate;
            }
        },
        WEEKEND {
            double overtimePay(double hrs, double payRate) {
                return hrs * payRate;
            }
        };

        abstract double overtimePay(double hrs, double payRate);

        double pay(double hrs, double payRate) {
            double base = hrs * payRate;
            return base + overtimePay(hrs, payRate);
        }
    }
}


