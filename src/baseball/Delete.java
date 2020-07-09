package baseball;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Delete {

    public void exec() {
        Configuration config = new Configuration();
        config = config.configure();
        SessionFactory sessionfactory = config.buildSessionFactory();
        Session session = sessionfactory.openSession();

        Transaction trans = session.beginTransaction();

//      削除対象オブジェクトの作成 
        MPlayer player = new MPlayer();
        player.setId(Integer.valueOf(2)); // ID 2であるPlayerオブジェクトをマーク
        session.delete(player); // 削除実行
        trans.commit();
        session.close();
    }
}