package by.dediev.chechenswearfilter;

public interface ChechenSwearFilter {
    boolean containsSwear(String text);
    String censorTest(String text);
}
