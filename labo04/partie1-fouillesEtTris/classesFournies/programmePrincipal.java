class programmePrincipal{
    public static void main(String[] args) {
        int[] tab = { 3, 5, 6, 8, 12, 13, 16, 20, 22, 24, 27, 31, 33, 35, 43, 46, 51, 53, 56, 58, 60, 63, 65, 67, 81 };

        System.out.println("\n" + UtilitaireFouilles.fouilleBinaire(53, tab));
        System.out.println("\n" + UtilitaireFouilles.fouilleBinaire(17, tab));

    }
}