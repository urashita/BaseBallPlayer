package baseball;

import java.util.Calendar;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Insert {

    public void exec() {
        Configuration config = new Configuration();
        config = config.configure();
        SessionFactory sessionfactory = config.buildSessionFactory();
        Session session = sessionfactory.openSession();

        Transaction trans = session.beginTransaction();

//      新しいレコードの作成
        MPlayer player = new MPlayer();

        player.setName("馬場　皐輔");

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1995);
        cal.set(Calendar.MONTH, Calendar.MAY);
        cal.set(Calendar.DAY_OF_MONTH, 18);
        Date dateRepresentation = cal.getTime();
        player.setBirthday(dateRepresentation);
        player.setPrefecture("宮城");

        session.save(player); // 挿入実行

        trans.commit();
        session.close();
    }
}