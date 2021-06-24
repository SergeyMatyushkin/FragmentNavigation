package ru.geekbrains.fragmentnavigation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
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
                // clickListener.onItemClick(noteEntity);
                // }
                //  });
                cardView.setCardBackgroundColor(new Random().nextInt());
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


    @SuppressLint("NonConstantResourceId")
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1_popup:
                break;
            case R.id.item2_popup:
                showBottomSheetDialog();
                return true;
        }
        return false;
    }


    private void showBottomSheetDialog() {
        new NoteDialogFragment().show(getSupportFragmentManager(), null);

    }


}
