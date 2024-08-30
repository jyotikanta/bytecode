package designpatterns.structural;

// Modern JPA interface (Target)
interface JpaRepository<T, ID> {
    T findById(ID id);
    void save(T entity);
    void delete(T entity);
}

// Legacy database access class (Adaptee)
class LegacyDbAccess {
    public Object getRecordById(String tableName, long id) {
        System.out.println("Fetching record from " + tableName + " with id " + id);
        return new Object(); // Simplified; assume this returns the actual record
    }

    public void insertRecord(String tableName, Object record) {
        System.out.println("Inserting record into " + tableName);
    }

    public void deleteRecord(String tableName, long id) {
        System.out.println("Deleting record from " + tableName + " with id " + id);
    }
}

// Entity class
class User {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Constructor, getters, setters omitted for brevity
}

// Adapter
class LegacyDbAdapter implements JpaRepository<User, Long> {
    private LegacyDbAccess legacyDb;
    private static final String USER_TABLE = "users";

    public LegacyDbAdapter(LegacyDbAccess legacyDb) {
        this.legacyDb = legacyDb;
    }

    @Override
    public User findById(Long id) {
        Object record = legacyDb.getRecordById(USER_TABLE, id);
        // Convert the record to User object (simplified)
        return new User(); // Assume we create a User from the record
    }

    @Override
    public void save(User user) {
        legacyDb.insertRecord(USER_TABLE, user);
    }

    @Override
    public void delete(User user) {
        legacyDb.deleteRecord(USER_TABLE, user.getId());
    }
}

// Client code
public class AdapterDemo {
    public static void main(String[] args) {
        LegacyDbAccess legacyDb = new LegacyDbAccess();
        JpaRepository<User, Long> userRepository = new LegacyDbAdapter(legacyDb);

        // Using the adapter
        User user = userRepository.findById(1L);
        userRepository.save(new User());
        userRepository.delete(user);
    }
}
