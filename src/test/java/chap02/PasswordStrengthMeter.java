package test.java.chap02;

/* 테스트 할 때 단위기능 별로 하는데 처음에는 테스트가 통과되도록 만들고
 * 이제 여러 기능을 추가하다보면 한 메소드가 길어지는데 그 때 마다 private으로 나눠주면
 * 되는거임! 정말 세세한 기능 하나하나 테스트 할 필요 없음 우리는 기능목록을 테스트 하면
 * 됨! */
public class PasswordStrengthMeter {

    public PasswordStrength meter(String s) {
        if (s == null || s.isEmpty()) {
            return PasswordStrength.INVALID;
        }
        int metCounts = getMetCriteriaCounts(s);

        if (metCounts <= 1) {
            return PasswordStrength.WEAK;
        }
        if (metCounts == 2) {
            return PasswordStrength.NORMAL;
        }

        return PasswordStrength.STRONG;
    }

    private int getMetCriteriaCounts(String s) {
        int metCounts = 0;
        if (s.length() >= 8) {
            metCounts++;
        }
        if (meetsContainingNumberCriteria(s)) {
            metCounts++;
        }
        if (meetsContainingUppercaseCriteria(s)) {
            metCounts++;
        }
        return metCounts;
    }

    private boolean meetsContainingNumberCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }

    private boolean meetsContainingUppercaseCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }


}
