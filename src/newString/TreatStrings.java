package newString;

public class TreatStrings
{
    public static String lessOne(String word)
    {
        String neword="";
        char temp;
        for(int i=0;i<word.length()-1;i++)
        {
            temp=word.charAt(i);
            neword=neword+Character.toString(temp);
        }
        return neword;
    }
    public static String oneLess(String word)
    {
        String neword="";
        char temp;
        for(int i=1;i<word.length();i++)
        {
            temp=word.charAt(i);
            neword=neword+Character.toString(temp);
        }
        return neword;
    }
    public static String getExtension(String word){
        String newWord="";
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)=='.'){
                for(int j=i;j<i+4;j++){
                    newWord=newWord+word.charAt(j);
                }
                return newWord;
            }
        }
        return null;
    }
    public static String clearSymbols(String word)
    {
        char temp;
        char [] unaccepted={'!','@','#','$','%','¨','&','*','(',')','_','-','+','=','§','¬','¢','£','³','²','¹',',','<','.','>',':',';','^','~','ª','º','[',']','{','}','´','`','|','+'};
        String nova="";
        boolean yes;
        for(int i=0;i<word.length();i++)
        {
            yes=false;
            temp=word.charAt(i);
            for(int j=0;j<unaccepted.length;j++)
            {
                if(temp==unaccepted[j])
                {
                    yes=true;
                }
            }
            if(yes==false)
            {
                nova+=Character.toString(temp);
            }
        }
        return nova;
    }
    public static String clearNumbers(String word)
    {
        char temp;
        char [] unaccepted={'0','1','2','3','4','5','6','7','8','9'};
        String nova="";
        boolean yes;
        for(int i=0;i<word.length();i++)
        {
            yes=false;
            temp=word.charAt(i);
            for(int j=0;j<unaccepted.length;j++)
            {
                if(temp==unaccepted[j])
                {
                    yes=true;
                }
            }
            if(yes==false)
            {
                nova+=Character.toString(temp);
            }
        }
        return nova;
    }
    public static String onlyNumbers(String word)
    {
        char temp;
        String nova="";
        for(int i=0;i<word.length();i++)
        {
            temp=word.charAt(i);
            switch(temp){
                case '1':
                    nova=nova+temp;
                    break;
                case '2':
                    nova=nova+temp;
                    break;
                case '3':
                    nova=nova+temp;
                    break;
                case '4':
                    nova=nova+temp;
                    break;
                case '5':
                    nova=nova+temp;
                    break;
                case '6':
                    nova=nova+temp;
                    break;
                case '7':
                    nova=nova+temp;
                    break;
                case '8':
                    nova=nova+temp;
                    break;
                case '9':
                    nova=nova+temp;
                    break;
                case '0':
                    nova=nova+temp;
                    break;
                default:
                    break;
            }
        }
        return nova;
    }
    public static String clearLetters(String word)
    {
        word=word.toLowerCase();
        char temp;
        char [] unaccepted={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','ç','á','à','â','ã','ä','é','è','ê','ë','í','ì','î','ï','ó','ò','ô','õ','ö','ú','ù','û','ü'};
        String nova="";
        boolean yes;
        for(int i=0;i<word.length();i++)
        {
            yes=false;
            temp=word.charAt(i);
            for(int j=0;j<unaccepted.length;j++)
            {
                if(temp==unaccepted[j])
                {
                    yes=true;
                }
            }
            if(yes==false)
            {
                nova+=Character.toString(temp);
            }
        }
        return nova;
    }
    public static String invertString(String frase)
    {
        char temp;
        String newString="";
        for(int i=0;i<=frase.length()-1;i++)
        {
            temp=frase.charAt(i);
            newString=Character.toString(temp)+newString;
        }
        return newString;
    }
    public static void main(String[]args)
    {
        System.out.println(getExtension("renato.jpg"));
    }
}
