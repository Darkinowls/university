
public class task25 {

    public static class monthes {
        String name ;
        int num  ;
        public  monthes ( String name , int num){
            this.name = name ;
            this.num = num ;
        }
    }

    public static void main(String[] args){

        int day = Integer.parseInt(args[0]);
        boolean hi = Boolean.parseBoolean(args[1]) ;

        day = day % ((hi)? 366 : 365) ;

        findDay( day , hi );

    }
    public static int findDay(int day , boolean hi ){

        monthes [] obj = new monthes[12] ;
        obj[0] = new monthes("jan", 0);
        obj[1] = new monthes("feb", 31);
        obj[2] = new monthes("mar", 59 + ((hi) ? 1 : 0));
        obj[3] = new monthes("apr", 90 + ((hi) ? 1 : 0));
        obj[4] = new monthes("may", 120 + ((hi) ? 1 : 0));
        obj[5] = new monthes("jun", 151 + ((hi) ? 1 : 0));
        obj[6] = new monthes("jul", 181 + ((hi) ? 1 : 0));
        obj[7] = new monthes("aug", 212 + ((hi) ? 1 : 0));
        obj[8] = new monthes("sep", 243 + ((hi) ? 1 : 0));
        obj[9] = new monthes("oct", 273 + ((hi) ? 1 : 0));
        obj[10] = new monthes("nov", 314 + ((hi) ? 1 : 0));
        obj[11] = new monthes("dec", 334 + ((hi) ? 1 : 0));

        int i = 0 ;
        for (  ; i < obj.length - 1 ; i++){
            if ( day > obj[i].num && day < obj[i+1].num  ) System.out.print(day - obj[i].num + " " + obj[i].name );
        }
        if ( day > obj[i].num ) System.out.print(day - obj[i].num + " " + obj[i].name );

        return day - obj[i].num ;
    }
}
