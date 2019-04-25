package cours13.exeinformatique.com.cours13;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TodoRecyclerAdapter extends RecyclerView.Adapter<TodoRecyclerAdapter.MyViewHolder> {
    private List<Todo> todoList;

    public TodoRecyclerAdapter(List<Todo> todoList) {
        this.todoList = todoList;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView description;
        TextView date;

        public MyViewHolder(View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.textView_date);
            title = itemView.findViewById(R.id.textView_Title);
            description = itemView.findViewById(R.id.textView_description);
        }
    }

    @NonNull
    @Override
    public TodoRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_card, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoRecyclerAdapter.MyViewHolder holder, int pos) {
        Todo todoToDisplay = todoList.get(pos);
        holder.title.setText(todoToDisplay.getTitle());
        holder.description.setText(todoToDisplay.getDescription());
        holder.date.setText(todoToDisplay.getDateAdded().toString());
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }
}
