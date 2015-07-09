package nl.littlerobots.cupboardgsontest;

import com.google.gson.Gson;

import android.content.ContentValues;
import android.test.AndroidTestCase;

import nl.qbusict.cupboard.Cupboard;
import nl.qbusict.cupboard.CupboardBuilder;

public class TestCupboardGson extends AndroidTestCase {

    public void testCupboardContentValues() {
        Cupboard cupboard = new CupboardBuilder().useAnnotations().build();
        cupboard.register(TestModel.class);

        TestModel model = new TestModel();
        model.setId(1L);
        model.setServerId(2L);

        ContentValues values = cupboard.withEntity(TestModel.class).toContentValues(model);
        assertTrue(values.containsKey("_id"));
        assertTrue(values.containsKey("serverId"));
        assertEquals(1L, (long) values.getAsLong("_id"));
        assertEquals(2L, (long) values.getAsLong("serverId"));

        model = new Gson().fromJson("{\n"
                + "  \"id\": 3,\n"
                + "  \"server_id\": 4\n"
                + "}", TestModel.class);

        assertEquals(3L, (long) model.getId());
        assertEquals(4L, (long) model.getServerId());

        values = cupboard.withEntity(TestModel.class).toContentValues(model);

        assertTrue(values.containsKey("_id"));
        assertTrue(values.containsKey("serverId"));
        assertEquals(3L, (long) values.getAsLong("_id"));
        assertEquals(4L, (long) values.getAsLong("serverId"));
    }
}
