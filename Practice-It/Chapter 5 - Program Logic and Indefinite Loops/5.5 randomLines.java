/**********************************************************************************************
Write a method called randomLines that prints between 5 and 10 random strings of letters
(between "a" and "z"), one per line. Each string should have random length of up to 80 characters.

                    rlcuhubm
                    ilons
                    ahidbxonunonheuxudxrcgdp
                    xmkmkmmmmwmwqjbaeeeerceheelciheihcreidercdeehiuhhhn
                    hdcrphdidcrydxgtkdhoendgcidgxfidgfufdgfuuuuuu

***********************************************************************************************/

public static void randomLines() {
    Random random = new Random();
    int nrOfStrings = random.nextInt(6) + 5;
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    for (int i = 1; i <= nrOfStrings; i++) {
        for (int j = 1; j <= random.nextInt(81); j++) {
            System.out.print(alphabet.charAt(random.nextInt(26)));
        }
        System.out.println();
    }
}
