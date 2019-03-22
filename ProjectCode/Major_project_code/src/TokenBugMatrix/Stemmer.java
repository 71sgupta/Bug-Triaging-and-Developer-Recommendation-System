package TokenBugMatrix;

import edu.stanford.nlp.process.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.function.Function;
import edu.stanford.nlp.ling.Word;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;


public class Stemmer implements Function<Word,Word> {
  private char[] b;
  private int i,     
  i_end, 
  j, k;
  private static final int INC = 50;

  
  public Stemmer() {
    b = new char[INC];
    i = 0;
    i_end = 0;
  }

  private void add(char ch) {
    if (i == b.length) {
      char[] new_b = new char[i + INC];
      for (int c = 0; c < i; c++) {
        new_b[c] = b[c];
      }
      b = new_b;
    }
    b[i++] = ch;
  }


  
  @Override
  public String toString() {
    return new String(b, 0, i_end);
  }

  private final boolean cons(int i) {
    switch (b[i]) {
      case 'a':
      case 'e':
      case 'i':
      case 'o':
      case 'u':
        return false;
      case 'y':
        return (i == 0) ? true : !cons(i - 1);
      default:
        return true;
    }
  }

 

  private final int m() {
    int n = 0;
    int i = 0;
    while (true) {
      if (i > j) {
        return n;
      }
      if (!cons(i)) {
        break;
      }
      i++;
    }
    i++;
    while (true) {
      while (true) {
        if (i > j) {
          return n;
        }
        if (cons(i)) {
          break;
        }
        i++;
      }
      i++;
      n++;
      while (true) {
        if (i > j) {
          return n;
        }
        if (!cons(i)) {
          break;
        }
        i++;
      }
      i++;
    }
  }

  

  private final boolean vowelinstem() {
    int i;
    for (i = 0; i <= j; i++) {
      if (!cons(i)) {
        return true;
      }
    }
    return false;
  }

  

  private final boolean doublec(int j) {
    if (j < 1) {
      return false;
    }
    if (b[j] != b[j - 1]) {
      return false;
    }
    return cons(j);
  }

  /*  e.g.
        cav(e), lov(e), hop(e), crim(e), but
        snow, box, tray.
  */

  private final boolean cvc(int i) {
    if (i < 2 || !cons(i) || cons(i - 1) || !cons(i - 2)) {
      return false;
    }
    {
      int ch = b[i];
      if (ch == 'w' || ch == 'x' || ch == 'y') {
        return false;
      }
    }
    return true;
  }

  private final boolean ends(String s) {
    int l = s.length();
    int o = k - l + 1;
    if (o < 0) {
      return false;
    }
    for (int i = 0; i < l; i++) {
      if (b[o + i] != s.charAt(i)) {
        return false;
      }
    }
    j = k - l;
    return true;
  }

  

  private void setto(String s) {
    int l = s.length();
    int o = j + 1;
    for (int i = 0; i < l; i++) {
      b[o + i] = s.charAt(i);
    }
    k = j + l;
  }

 

  private final void r(String s) {
    if (m() > 0) {
      setto(s);
    }
  }

  

  private void step1() {   /*rid of plurals and -ed or -ing. e.g.
         
  */
    if (b[k] == 's') {
      if (ends("sses")) {
        k -= 2;
      } else if (ends("ies")) {
        setto("i");
      } else if (b[k - 1] != 's') {
        k--;
      }
    }
    if (ends("eed")) {
      if (m() > 0) {
        k--;
      }
    } else if ((ends("ed") || ends("ing")) && vowelinstem()) {
      k = j;
      if (ends("at")) {
        setto("ate");
      } else if (ends("bl")) {
        setto("ble");
      } else if (ends("iz")) {
        setto("ize");
      } else if (doublec(k)) {
        k--;
        {
          int ch = b[k];
          if (ch == 'l' || ch == 's' || ch == 'z') {
            k++;
          }
        }
      } else if (m() == 1 && cvc(k)) {
        setto("e");
      }
    }
  }

 

  private final void step2() {
    if (ends("y") && vowelinstem()) {
      b[k] = 'i';
    }
  }

  

  private final void step3() {
    if (k == 0) {
      return; /* For Bug 1 */
    }
    switch (b[k - 1]) {
      case 'a':
        if (ends("ational")) {
          r("ate");
          break;
        }
        if (ends("tional")) {
          r("tion");
          break;
        }
        break;
      case 'c':
        if (ends("enci")) {
          r("ence");
          break;
        }
        if (ends("anci")) {
          r("ance");
          break;
        }
        break;
      case 'e':
        if (ends("izer")) {
          r("ize");
          break;
        }
        break;
      case 'l':
        if (ends("bli")) {
          r("ble");
          break;
        }
        if (ends("alli")) {
          r("al");
          break;
        }
        if (ends("entli")) {
          r("ent");
          break;
        }
        if (ends("eli")) {
          r("e");
          break;
        }
        if (ends("ousli")) {
          r("ous");
          break;
        }
        break;
      case 'o':
        if (ends("ization")) {
          r("ize");
          break;
        }
        if (ends("ation")) {
          r("ate");
          break;
        }
        if (ends("ator")) {
          r("ate");
          break;
        }
        break;
      case 's':
        if (ends("alism")) {
          r("al");
          break;
        }
        if (ends("iveness")) {
          r("ive");
          break;
        }
        if (ends("fulness")) {
          r("ful");
          break;
        }
        if (ends("ousness")) {
          r("ous");
          break;
        }
        break;
      case 't':
        if (ends("aliti")) {
          r("al");
          break;
        }
        if (ends("iviti")) {
          r("ive");
          break;
        }
        if (ends("biliti")) {
          r("ble");
          break;
        }
        break;
      case 'g':
        if (ends("logi")) {
          r("log");
          break;
        }
    }
  }

  

  private final void step4() {
    switch (b[k]) {
      case 'e':
        if (ends("icate")) {
          r("ic");
          break;
        }
        if (ends("ative")) {
          r("");
          break;
        }
        if (ends("alize")) {
          r("al");
          break;
        }
        break;
      case 'i':
        if (ends("iciti")) {
          r("ic");
          break;
        }
        break;
      case 'l':
        if (ends("ical")) {
          r("ic");
          break;
        }
        if (ends("ful")) {
          r("");
          break;
        }
        break;
      case 's':
        if (ends("ness")) {
          r("");
          break;
        }
        break;
    }
  }

  

  private final void step5() {
    if (k == 0) {
      return; /* for Bug 1 */
    }
    switch (b[k - 1]) {
      case 'a':
        if (ends("al")) {
          break;
        }
        return;
      case 'c':
        if (ends("ance")) {
          break;
        }
        if (ends("ence")) {
          break;
        }
        return;
      case 'e':
        if (ends("er")) {
          break;
        }
        return;
      case 'i':
        if (ends("ic")) {
          break;
        }
        return;
      case 'l':
        if (ends("able")) {
          break;
        }
        if (ends("ible")) {
          break;
        }
        return;
      case 'n':
        if (ends("ant")) {
          break;
        }
        if (ends("ement")) {
          break;
        }
        if (ends("ment")) {
          break;
        }
        
        if (ends("ent")) {
          break;
        }
        return;
      case 'o':
        if (ends("ion") && j >= 0 && (b[j] == 's' || b[j] == 't')) {
          break;
        }
        
        if (ends("ou")) {
          break;
        }
        return;
        
      case 's':
        if (ends("ism")) {
          break;
        }
        return;
      case 't':
        if (ends("ate")) {
          break;
        }
        if (ends("iti")) {
          break;
        }
        return;
      case 'u':
        if (ends("ous")) {
          break;
        }
        return;
      case 'v':
        if (ends("ive")) {
          break;
        }
        return;
      case 'z':
        if (ends("ize")) {
          break;
        }
        return;
      default:
        return;
    }
    if (m() > 1) {
      k = j;
    }
  }

  

  private final void step6() {
    j = k;
    if (b[k] == 'e') {
      int a = m();
      if (a > 1 || a == 1 && !cvc(k - 1)) {
        k--;
      }
    }
    if (b[k] == 'l' && doublec(k) && m() > 1) {
      k--;
    }
  }

  
  private void stem() {
    k = i - 1;
    if (k > 1) {
      step1();
      step2();
      step3();
      step4();
      step5();
      step6();
    }
    i_end = k + 1;
    i = 0;
  }

  
  public static void main(String[] args) throws IOException {
    Stemmer s = new Stemmer();
    
    FileOutputStream fout=new  FileOutputStream("C:\\Users\\HP\\Desktop\\sample1.txt");
     File file = new File("C:\\Users\\HP\\Desktop\\sample.txt");
    FileInputStream fis = new FileInputStream(file);
    String bit = "";
    ArrayList<String> list = new ArrayList<String>();
    Iterator<Word> it = PTBTokenizer.newPTBTokenizer(new InputStreamReader(fis, "utf-8"));
    while (it.hasNext()) {
        Word token = it.next();
        System.out.print(s.stem(token.word()));
        System.out.print(' ');
        list.add(s.stem(token.word()));
    } 
    for(int i=0;i<list.size();i++)
    {    
         bit+=list.get(i)+",";
        System.out.println(list.get(i));       
    }
        byte b[]=bit.getBytes();            
        fout.write(b); 
    
    
    System.out.println();
  }

  

  public String stem(String s) {
    char[] characters = s.toCharArray();
    for (int i = 0; i < characters.length; i++) {
      add(characters[i]);
    }
    stem();
    return toString();
  }

 

  public Word stem(Word w) {
    return (new Word(stem(w.word())));
  }

  
  public Word apply(Word word) {
    return stem(word);
  }

}
