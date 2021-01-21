package ru.netology.data;

public class CardGenerator {
    private CardGenerator() {

    }

    public static class CardInfo {
        private static final String approvedCardNumber = "4444 4444 4444 4441";
        private static final String declinedCardNumber = "4444 4444 4444 4442";
        private static final String unknownCardNumber = "5555 5555 5555 5555";
        private static final String incorrectCardNumber = "5555 5555 5555";
        private static final String validCardMonth = "08";
        private static final String validCardYear = "24";
        private static final String validCardOwner = "Ivanov Ivan";
        private static final String validCardCvcCvv = "999";

        private static final String tooSmallYear = "12";
        private static final String incorrectMonth = "13";
        private static final String incorrectCvcCvv = "98";
        private static final String incorrectOwnerCyrillic = "Иванов Иван";

        public static Card getCardInfoWithApprovedCardNumber() {
            return new Card(approvedCardNumber, validCardMonth, validCardYear, validCardOwner, validCardCvcCvv);
        }

        public static Card getCardInfoWithDeclinedCardNumber() {
            return new Card(declinedCardNumber, validCardMonth, validCardYear, validCardOwner, validCardCvcCvv);
        }

        public static Card getCardInfoWithUnknownCardNumber() {
            return new Card(unknownCardNumber, validCardMonth, validCardYear, validCardOwner, validCardCvcCvv);
        }

        public static Card getCardInfoWithExpiredDate() {
            return new Card(approvedCardNumber, validCardMonth, tooSmallYear, validCardOwner, validCardCvcCvv);
        }
        public static Card getCardInfoWithIncorrectMonth() {
            return new Card(approvedCardNumber, incorrectMonth, validCardYear, validCardOwner, validCardCvcCvv);
        }

        public static Card getCardInfoWithIncorrectCvvCvc() {
            return new Card(approvedCardNumber, validCardMonth, validCardYear, validCardOwner, incorrectCvcCvv);
        }

        public static Card getCardInfoWithIncorrectCardNumberAndCvc() {
            return new Card(
                    incorrectCardNumber, tooSmallYear, validCardYear, validCardOwner, incorrectCvcCvv);
        }

        public static Card getCardInfoWithIncorrectOwnerByCyrillic() {
            return new Card(
                    approvedCardNumber, validCardMonth, validCardYear, incorrectOwnerCyrillic, validCardCvcCvv);
        }

    }
}
