package baseball;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.persistence.criteria.CriteriaQuery;

public class Find {
    public void exec() {
        Configuration config = new Configuration();
        config = config.configure(); // 設定の読み込み

//      セッションファクトリーの作成
        SessionFactory sessionfactory = config.buildSessionFactory();

//      セッションオープン
        Session session = sessionfactory.openSession();

        // create Criteria
        CriteriaQuery<MPlayer> criteriaQuery = session.getCriteriaBuilder().createQuery(MPlayer.class);
        criteriaQuery.from(MPlayer.class);

        List<MPlayer> list = session.createQuery(criteriaQuery).getResultList();

        for (int i = 0; i < list.size(); i++) {
//          レコードとなるMPlayerオブジェクトを取得
            MPlayer player = (MPlayer) list.get(i);

//          idとname列のデータを表示
            System.out.println(player.getId() + ":" + player.getName());
        }
    }
}