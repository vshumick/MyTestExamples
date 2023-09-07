package v1ch14;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test10 {
    public static void main(String[] args) {

        ///////////////////////////////////
        // IP адрес
        String regexp = "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";

        String str = "gasdgasgsdg192.168.0.1fgsdfgsdg57sgsdfg192.168.0.2rt666#hetrh  wtehwth 192.168.10.30sfdsdg 7dgb @@@";
                     //"gssdfgsdfgsd  3452  & ";

        Pattern pattern = Pattern.compile(regexp);

        Matcher matcher = pattern.matcher(str);

        int start = 0;

        Map<String, int[]> map = new LinkedHashMap<>();

        while (matcher.find(start)) {
            //System.out.println(matcher.group());
            map.put(matcher.group(), new int[]{matcher.start()+1, matcher.end()});
            start = matcher.end();
        }
        for (Map.Entry<String, int[]> entry : map.entrySet())
            System.out.println(entry.getKey() + ": " + "[" + entry.getValue()[0] + ", " + entry.getValue()[1] + "]");


        ///////////////////////////////////

        System.out.println("--------------------------------------------");

    }
}
