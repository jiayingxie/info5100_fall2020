public interface Boardable {
    // !!!pay attention: methods in interface are public abstract,
    // so we do not need to add public modifier
    void setBoardStart(int month, int day, int year);
    void setBoardEnd(int month, int day, int year);
    boolean boarding(int month, int day, int year);

}
