class Util {

    public static int indexOf(String src, String tgt) {

        if (src.equals("")) {
            return -1;
        } else if (src.startsWith(tgt)) {
            return 0;
        } else {
            int resultIndex = indexOf(src.substring(1), tgt);
            return resultIndex == -1 ? -1 : resultIndex + 1;
        }

    }

}