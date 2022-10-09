public class PageId{

	
  private int fileIdx;
  private int pageIdx;
  //cas vide
  public PageId(){
    
  }
  //cas ave parametre
  public PageId (int fileIdx, int pageIdx){
    this.fileIdx=fileIdx;
    this.pageIdx=pageIdx;
  }

  public int getId(){
    return fileIdx;
  }

  public int getIndice (){
    return pageIdx;
  }

  public void setId(int newId){
    this.fileIdx=newId;
  }

  public void setIndice(int newIndice){
    this.pageIdx=newIndice;
  }
}