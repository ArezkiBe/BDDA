public Class PageId{

  
  private int fileIdx;
  private int pageIdx;
  
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

  public int setId(int newId){
    this.fileIdx=newId;
  }

  public int setIndice(int newIndice){
    this.pageIdx=newIndice;
  }
}