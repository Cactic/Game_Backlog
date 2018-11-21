package com.example.prive.game_backlog;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.GamesViewHolder> {

    private List<Game> gameList;
    private Context context;

    public GamesAdapter(List<Game> gameList, Context context) {
        this.gameList = gameList;
        this.context = context;
    }

    @NonNull
    @Override
    public GamesAdapter.GamesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cardview, parent, false);

        // Return a new holder instance

        GamesAdapter.GamesViewHolder gamesViewHolder = new GamesAdapter.GamesViewHolder(view);
        return gamesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GamesViewHolder holder, int position) {
        final Game game = gameList.get(position);
        holder.title.setText(game.getName());
        holder.platform.setText(game.getPlatform());
        holder.status.setText(game.getStatus());
        holder.date.setText(game.getDate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context = v.getContext();
                Intent intent = new Intent(context, ChangeInfoActivity.class);
                intent.putExtra("Game", game);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }

    public class GamesViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView platform;
        public TextView status;
        public TextView date;

        GamesViewHolder(View gameView) {

            super(gameView);

            title = (TextView) gameView.findViewById(R.id.CardName);
            platform = (TextView) gameView.findViewById(R.id.CardPlatform);
            status = (TextView) gameView.findViewById(R.id.CardStatus);
            date = (TextView) gameView.findViewById(R.id.CardDate);
        }
    }
}

