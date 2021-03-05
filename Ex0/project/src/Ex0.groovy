

import groovy.io.FileType
//get list of file in groovy
//https://stackoverflow.com/questions/3953965/get-a-list-of-all-the-files-in-a-directory-recursive
//read file from groovy
//https://www.baeldung.com/groovy-file-read
//create file in groovy
//https://stackoverflow.com/questions/48566158/how-to-create-text-file-using-groovy/48566868
class Ex0 {

    static final path = "E:\\lev\\ekronot\\Ex0\\ext\\"

    static void main(args) {
        //
        Shop shop = new Shop()
        String txt = ""
        //get just  vm  files from folder
        def files = FileEvents.getFilesInFolder(path, "vm")
        def folderName = FileEvents.getFolderName(path)
        //read the files in the folder
        files.each {
            def fileData = FileEvents.readFile(it.path)
            txt += fileData.getNameWithoutExtension() + "\n"
            fileData.lines.each { line ->
                def arr = line.split(' ')
                if (arr[0] == "buy") {
                    txt += shop.HandleBuy(arr[1], Float.parseFloat(arr[2]), Float.parseFloat(arr[3]))
                }
                if (arr[0] == "cell") {
                    txt += shop.HandleCell(arr[1], Float.parseFloat(arr[2]), Float.parseFloat(arr[3]))
                }
            }
        }

        txt += String.format( "TOTAL BUY:%.2f%nTOTAL CELL:%.2f%n", shop.totalBuy, shop.totalSell)

        println(txt)
        //create the file
        FileEvents.createFile(txt, path + "/" + folderName + ".asm")

    }
}
