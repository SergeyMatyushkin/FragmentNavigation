package ru.geekbrains.fragmentnavigation;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Random;

public class NoteViewHolder extends RecyclerView.ViewHolder implements PopupMenu.OnMenuItemClickListener {
    private final TextView subjectTextView;
    private final TextView phoneTextView;
    private final CardView cardView;
    private NoteEntity noteEntity;

    public NoteViewHolder(@NonNull ViewGroup parent, @Nullable NotesAdapter.OnItemClickListener clickListener) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false));
        cardView = (CardView) itemView;
        subjectTextView = itemView.findViewById(R.id.subject_text_view);
        phoneTextView = itemView.findViewById(R.id.phone_text_view);
        cardView.setOnClickListener(v -> {
            if (clickListener != null) {
                //clickListener.onItemClick(noteEntity);
                //}
                //});
                //cardView.setCardBackgroundColor(new Random().nextInt());
                PopupMenu popupMenu = new PopupMenu(cardView.getContext(), cardView);
                popupMenu.inflate(R.menu.note_menu);
                popupMenu.setOnMenuItemClickListener(this);
                popupMenu.show();
            }
        });
    }

    public void bind(NoteEntity noteEntity) {
        this.noteEntity = noteEntity;
        subjectTextView.setText(noteEntity.subject);
        phoneTextView.setText(noteEntity.phone);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        Toast.makeText(cardView.getContext(), "Нажал, молодец!)", Toast.LENGTH_SHORT).show();

        return true;
    }
}
