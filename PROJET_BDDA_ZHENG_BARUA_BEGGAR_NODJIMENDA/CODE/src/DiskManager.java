import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class DiskManager {

  public static DiskManager LeDisqueManager = new DiskManager();
  private static byte[] buffer ;
  //nous utileserons une table pour les case libre et une table pour les cases remplie
  public ArrayList<PageId> PageDispo = new ArrayList<PageId>();
  public ArrayList<PageId> PageNonDispo = new ArrayList<PageId>();

  public DiskManager getDisque(){
    return LeDisqueManager;
  }
  public PageId allocPage(){
    PageId Page = new PageId();
    int numero_fichier=0;
    File fichier = new File(DBParams.DBPath + "/f" +numero_fichier + ".bdda");
  }
  public void ReadPage (PageId pageId, buffer){
    
  }

  public void WritePage (PageId pageId, buffer) {
    
  }

  public void DeallocPage(PageId pageId) {

  }

  public int GetCurrentCountAllocPages() {

  }

  /*
   * public PageId AllocPage(){
   * 
   * 
   * }
   */

}