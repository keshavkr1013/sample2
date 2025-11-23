package LLDQuestions.VendingMachine;

public enum Coin {
    NICKEL(5),
    COPPER(10),
    IRON(15);
    public int value;
    private Coin(int value)
    {
        this.value = value;
    }
}
