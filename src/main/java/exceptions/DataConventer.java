package exceptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataConventer {
    public int convertToInt(String numberAsText) {

        // bu örnekte hatayı tespit ediyoruz ve oluştuğu noktada önlemler alıyoruz.
        try {
            int number = Integer.parseInt(numberAsText);
            return number;
        }
        catch (NumberFormatException e) {
            e.printStackTrace();
            // bu kısımda mutlaka loglama yapmanız önerilir.
            // kurumsal projelerde hata takibi ve logların izlenmesi hataların çözümü için çok önemlidir.
        }
        catch (NullPointerException e) {
            // farklı hata tiplerine göre birden fazla catch bloğu açabilirsiniz.
            e.printStackTrace();
        }

        return -1;
    }


    public Date convertToDate(String dateAsText) throws ParseException {

        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

        // bu örnekte ise String haldeki date bilgisini Date verisine çevirmeye çalıştık.
        // parse fonksiyonu "ParseException" tipinde bir hata fırlattığı için biz de bu hatayı çağrıldığımız bir üste ilettik.
        return dateFormatter.parse(dateAsText);
    }
}
