
import java.awt.Color;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class DocumentStyle {
    String reserved = "";
    public DocumentStyle(){
        String keywords[] = {"select","from","insert","delete","into","disdinct","update","alter","create","values",
                                "as","asc","desc","char","between","and","escape","not","by","case","commit","or","where"};
        StringBuilder builder = new StringBuilder();
        for(String str : keywords){
            builder.append(str).append("|");
        }
       reserved =  builder.substring(0, builder.length()-1);
       
    }
    
    public DefaultStyledDocument getDocumentStyle(){
        
        DefaultStyledDocument doc = new DefaultStyledDocument() {
            StyleContext cont = StyleContext.getDefaultStyleContext();
            AttributeSet attrBold = cont.addAttribute(cont.getEmptySet(), StyleConstants.Bold, true);
            AttributeSet attr = cont.addAttribute(attrBold, StyleConstants.Foreground, Color.BLUE);
            AttributeSet attrBlack = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.BLACK);
        
            public void insertString (int offset, String str, AttributeSet a) throws BadLocationException {
                super.insertString(offset, str, a);
                
                String text = getText(0, getLength());
                text = text.toLowerCase();
                int before = findLastNonWordChar(text, offset);
                if (before < 0) before = 0;
                int after = findFirstNonWordChar(text, offset + str.length());
                int wordL = before;
                int wordR = before;

                while (wordR <= after) {
                    if (wordR == after || String.valueOf(text.charAt(wordR)).matches("\\W")) {
                        if (text.substring(wordL, wordR).matches("(\\W)*("+reserved+")"))
                            setCharacterAttributes(wordL, wordR - wordL, attr, false);
                        else
                            setCharacterAttributes(wordL, wordR - wordL, attrBlack, false);
                        wordL = wordR;
                    }
                    wordR++;
                }
            }

            public void remove (int offs, int len) throws BadLocationException {
                super.remove(offs, len);
                
                String text = getText(0, getLength());
                text = text.toLowerCase();
                int before = findLastNonWordChar(text, offs);
                if (before < 0) before = 0;
                int after = findFirstNonWordChar(text, offs);

                if (text.substring(before, after).matches("(\\W)*("+reserved+")")) {
                    setCharacterAttributes(before, after - before, attr, false);
                } else {
                    setCharacterAttributes(before, after - before, attrBlack, false);
                }
            }
        };
        
        return doc;
    }
    
     private int findLastNonWordChar (String text, int index) {
        while (--index >= 0) {
            if (String.valueOf(text.charAt(index)).matches("\\W")) {
                break;
            }
        }
        return index;
    }

     private int findFirstNonWordChar (String text, int index) {
        while (index < text.length()) {
            if (String.valueOf(text.charAt(index)).matches("\\W")) {
                break;
            }
            index++;
        }
        return index;
    }
}