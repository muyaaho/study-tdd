package test.java.chap02;

/* 테스트 할 때 단위기능 별로 하는데 처음에는 테스트가 통과되도록 만들고
* 이제 여러 기능을 추가하다보면 한 메소드가 길어지는데 그 때 마다 private으로 나눠주면
* 되는거임! 정말 세세한 기능 하나하나 테스트 할 필요 없음 우리는 기능목록을 테스트 하면
* 됨! */
public class PasswordStrengthMeter {

    public PasswordStrength meter(String s){
        if (s.length() < 8){
            return PasswordStrength.NORMAL;
        }
        boolean containsNum  = meetsContainingNumberCriteria(s);
        if (!containsNum) return PasswordStrength.NORMAL;
        return PasswordStrength.STRONG;
    }

    private boolean meetsContainingNumberCriteria(String s){
        for (char ch: s.toCharArray()){
            if (ch >= '0' && ch <= '9'){
                return true;
            }
        }
        return false;
    }


}
