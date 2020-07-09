package baseball;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Update {
    public void exec() {

        Configuration config = new Configuration();
        config = config.configure();
        SessionFactory sessionfactory = config.buildSessionFactory();
        Session session = sessionfactory.openSession();

//     トランザクションの開始
        Transaction trans = session.beginTransaction();

//      ID 4であるPlayerオブジェクトを取得
        MPlayer player = (MPlayer) session.load(MPlayer.class, Integer.valueOf(4));

        player.setName("藤浪　晋太郎");
        
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1994);
        cal.set(Calendar.MONTH, Calendar.APRIL);
        cal.set(Calendar.DAY_OF_MONTH, 12);
        Date dateRepresentation = cal.getTime();
        player.setBirthday(dateRepresentation);
        
        player.setPrefecture("大阪");

        session.update(player); // UPDATE実行

        trans.commit(); // コミット
        session.close(); // クローズ
    }
}