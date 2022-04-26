public class Main {
    public static void main(String[] args) {
        /*
        Измените класс TxtInputStream так, чтобы он работал только с txt-файлами (*.txt)
        Например, first.txt или name.1.part3.txt
        Если передан не txt-файл, например,
        file.txt.exe, то конструктор должен выбрасывать исключение UnsupportedFileNameException
         */
        String path = "C://test/file.png";
        TxtInputStream txtInputStream = new TxtInputStream(path);
    }
}