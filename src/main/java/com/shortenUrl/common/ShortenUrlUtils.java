

package com.shortenUrl.common;

import static java.lang.Math.floor;

/**
 *
 * @author abdalrahman.sharawy
 */
public class ShortenUrlUtils {
    
    static int  length =  Defines.Statics.CHAR_SET.length();
     public  String  generatShortCode(int id){
        
        String code = "";
        while (id > length - 1){
            code += "" + Defines.Statics.CHAR_SET.charAt(id % length);
            id = (int) floor(id/length);
        }
        
        code += Defines.Statics.CHAR_SET.charAt(id) ;
        return code;
    }
     
     
    public static void main(String[] args) {

    }
}
