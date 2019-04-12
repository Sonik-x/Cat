public enum CatColor {
    black,
    white,
    mackerel,
    ginger,
    tricolor,
    spotted;
    private static CatColor[] allValues = values();
    public static CatColor fromOrdinal(int n) {return allValues[n];}
}
