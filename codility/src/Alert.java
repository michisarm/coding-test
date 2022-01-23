import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Alert {

    interface AlertDAO {
        UUID addAlert(Date time);
        Date getAlert(UUID id);
    }

    class AlertService {
        AlertDAO storage;
        public AlertService(AlertDAO alertDAO) {
            this.storage = alertDAO;
        }
        public UUID raiseAlert() {
            return this.storage.addAlert(new Date());
        }

        public Date getAlertTime(UUID id) {
            return this.storage.getAlert(id);
        }
    }

    class MapAlertDAO implements AlertDAO{
        private final Map<UUID, Date> alerts = new HashMap<UUID, Date>();

        public UUID addAlert(Date time) {
            UUID id = UUID.randomUUID();
            this.alerts.put(id, time);
            return id;
        }

        public Date getAlert(UUID id) {
            return this.alerts.get(id);
        }
    }
}
