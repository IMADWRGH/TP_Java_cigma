package TP_heritage.TP2;

public class Biblio implements IBiblio{
  private  Document[] D;
  private int nbr_d;

    public Biblio(int nbr_d) {
        D=new Document[nbr_d];
    }

    public void Ajouter (Document D)
  {
            this.D[nbr_d++] =D;
  }
  public int Rechercher(int ref)
  {
      for (int i=0;i< nbr_d;i++)
          if (D[i].getReference()==ref)
              return i;
      return -1;
  }
  public void Afficher()
  {
      for (int i=0;i<nbr_d;i++)
      {
          D[i].Afficher();
      }
  }
  public void Supprimer(int reference)
  {
      int ref=Rechercher(reference);
      if (ref!=-1) {
          for (int i=0 ;i< nbr_d;i++) {
              this.D[i] = this.D[i + 1];
              nbr_d--;
          }
      }
      else {
          System.out.println("aucun document ont cette référence");
      }
  }
  public void Convertir_nom (int reference)
  {
      int ref=Rechercher(reference);
      if (ref!=-1) {
          for (int i=0 ;i< nbr_d;i++) {
              this.D[i].setTitre(D[i].getTitre().toUpperCase());
          }
      }
      else {
          System.out.println("aucun document ont cette référence");
      }
  }
  public void Nombre_livre ()
  {
      int nbr_livre=0;
      for (int i=0 ;i< nbr_d;i++) {
         if(D[i].getClass().equals(Livre.class))
             nbr_livre++;
      }
      System.out.println("Le nombre de livre est :"+nbr_livre);
  }
  public void Afficher_Dictionnaire()
  {
      for (int i=0;i<nbr_d;i++)
      {
          if (D[i].getClass().equals(Dictionnaire.class))
              D[i].Afficher();
      }
  }
public void Modifier(int reference,String titre)
{
    int ref=Rechercher(reference);
    if (ref!=-1)
    {
        for (int i=0;i<nbr_d;i++)
        {
            D[i].setTitre(titre);
        }
    }
    else
    {
        System.out.println("aucun document ont cette référence");

    }
}
  public void tousLesAuteurs()
  {
      for (int i=0 ;i< nbr_d;i++) {
          System.out.println("le numéros de  Dictionnaire  : "+ D[i].getReference()+" est son titre "+D[i].getTitre());
          if (D[i] instanceof Livre)
              System.out.println(" son auteur "+((Livre) D[i]).getAuteur());

      }
  }
public void toutesLesDescriptions()
{
for (int i=0;i<nbr_d;i++)
{
    D[i].description();
}
}

public void Trier_titre()// must change this function
{
    Document expD;
    boolean p=true;
    while(p) {
        p=false;
        for (int i = 0; i < nbr_d-1; i++) {
            if (D[i].getTitre().compareTo(D[i + 1].getTitre()) > 0) {
                expD = D[i];
                D[i] = D[i + 1];
                D[i + 1] = expD;
                p=true;
            }
        }
    }


}

    @Override
    public void Afficher(int ref) {
        int reference=Rechercher(ref);
        if (reference!=-1)
        {
            for (int i=0;i<nbr_d;i++)
            {
                D[i].Afficher();
            }
        }
    }

}
