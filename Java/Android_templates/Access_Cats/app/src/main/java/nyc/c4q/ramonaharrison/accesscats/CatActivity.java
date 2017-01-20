package nyc.c4q.ramonaharrison.accesscats;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import nl.qbusict.cupboard.QueryResultIterable;
import nyc.c4q.ramonaharrison.accesscats.model.Cat;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class CatActivity extends AppCompatActivity implements CatAdapter.Listener {

    private static final String TAG = CatActivity.class.getSimpleName();

    private RecyclerView catList;
    private EditText catNameInput;
    private Button addCatButton;

    private CatAdapter catAdapter;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);

        // get an instance of the DatabaseHelper
        AnimalDatabaseHelper dbHelper = AnimalDatabaseHelper.getInstance(this);
        db = dbHelper.getWritableDatabase();

        catNameInput = (EditText) findViewById(R.id.et_cat_name);

        addCatButton = (Button) findViewById(R.id.btn_add_cat);
        addCatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String catName = catNameInput.getText().toString();

                if (!catName.isEmpty()) {
                    catNameInput.setText("");
                    Long lastFed = Calendar.getInstance().getTimeInMillis(); // Feed the cat
                    addCat(new Cat(catName, lastFed));

                    refreshCatList();
                } else {
                    Toast.makeText(CatActivity.this, "Don't forget a name!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        catAdapter = new CatAdapter(selectAllCats(), this);

        catList = (RecyclerView) findViewById(R.id.rv_cat);
        catList.setLayoutManager(new LinearLayoutManager(this));
        catList.setAdapter(catAdapter);
    }

    private void addCat(Cat cat) {
        cupboard().withDatabase(db).put(cat);
    }

    private List<Cat> selectAllCats() {
        List<Cat> cats = new ArrayList<>();

        try {
            // Iterate cats
            QueryResultIterable<Cat> itr = cupboard().withDatabase(db).query(Cat.class).query();
            for (Cat cat : itr) {
                cats.add(cat);
            }
            itr.close();
        } catch (Exception e) {
            Log.e(TAG, "selectAllCats: ", e);
        }

        return cats;
    }

    private void refreshCatList() {
        catAdapter.setData(selectAllCats());
    }

    @Override
    public void onCatClicked(Cat cat) {
        // TODO feed the cat!
        Toast.makeText(this, "Meow", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCatLongClicked(Cat cat) {
        // TODO delete the cat!
        Toast.makeText(this, "Rawr!", Toast.LENGTH_SHORT).show();
    }
}
