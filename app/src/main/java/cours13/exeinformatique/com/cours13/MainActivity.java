package cours13.exeinformatique.com.cours13;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final Context context = this;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<Todo> todoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView_Todo);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new TodoRecyclerAdapter(todoList);
        recyclerView.setAdapter(adapter);
        setListener();
    }

    private void setListener(){
        findViewById(R.id.btn_dialogTodo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.create_dialog);
                Button dialogButtonAdd = dialog.findViewById(R.id.btn_addTodo);

                dialogButtonAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText editTextTitle = dialog.findViewById(R.id.editText_title);
                        EditText editTextDescription = dialog.findViewById(R.id.editText_description);
                        Todo todoToAdd = new Todo(
                                new Date(),
                                editTextTitle.getText().toString(),
                                editTextDescription.getText().toString()
                        );
                        todoList.add(todoToAdd);
                        adapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }
}
