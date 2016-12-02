package com.dezelin.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.dezelin.common.BoardPosition;
import com.dezelin.common.Chessman;
import com.dezelin.common.Fen;

import java.util.Iterator;

public class Board extends View {

    private static final int TEXT_SIZE = 10; // sp
    private static final int WIDTH = 128; // dp

    private static final char[] mFiles = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
    private static final char[] mRanks = { '1', '2', '3', '4', '5', '6', '7', '8' };

    private static final int BLACK_COLOR = Color.parseColor("#d38d47");
    private static final int WHITE_COLOR = Color.parseColor("#fbcd9c");

    private static Bitmap[] mBitmaps = new Bitmap[12];
    private static Rect mRect = new Rect();

    private Paint mPaint;
    private int mWidth;
    private float mScale;

    private int mLetterBoundWidth;
    private int mLetterBoundHeight;

    private BoardPosition mBoardPosition;
    private boolean mShowMargin;
    private boolean mWhitePlayer;

    public Board(Context context) {
        super(context);
    }

    public Board(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.Board, 0, 0);

        try {
            final String fen = a.getString(R.styleable.Board_fen);
            final boolean showMargin = a.getBoolean(R.styleable.Board_showMargin, true);
            final boolean whitePlayer = a.getBoolean(R.styleable.Board_whitePlayer, true);

            setFen(fen);
            setShowMargin(showMargin);
            setWhitePlayer(whitePlayer);
        } finally {
            a.recycle();
        }

        init();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = Math.min(w, h);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int minWidth = mWidth + getPaddingLeft() + getPaddingRight();
        int width = resolveSizeAndState(minWidth, widthMeasureSpec, 0);

        int minHeight = mWidth + getPaddingTop() + getPaddingBottom();
        int height = resolveSizeAndState(minHeight, heightMeasureSpec, 0);

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        final int strokeWidth = 1;
        final int margin = mShowMargin ? mLetterBoundHeight : 0;
        final int cellWidth = (int)((mWidth - 2 * margin - 2 * strokeWidth) / 8.0f + 0.5f);
        final int cellWidthHalf = (int)(cellWidth / 2.0 + 0.5f);

        final Chessman[][] board = mBoardPosition.getBoard();

        // Draw board cells
        mPaint.setStrokeWidth(strokeWidth);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setTextSize(TEXT_SIZE * mScale);
        mPaint.setFilterBitmap(true);

        final int cellAscent = (int) (mPaint.ascent() + mPaint.descent());
        final int cellCenterOffset = (int)((cellWidth - cellAscent) / 2.0 + 0.5f);

        int current = 0;

        while(current < 8 * 8) {

            final int i = current % 8;
            final int j = current / 8;

            int x = margin + i * cellWidth + strokeWidth;
            int y = margin + j * cellWidth + strokeWidth;
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(((i + j) % 2 == 0) ? WHITE_COLOR : BLACK_COLOR);
            canvas.drawRect(x, y, x + cellWidth, y + cellWidth, mPaint);

            final Chessman piece = getWhitePlayer() ? board[i][8 - j - 1] : board[8 - i - 1][j];
            if (piece != null) {
                mPaint.setColor(Color.WHITE);
                mPaint.setStyle(Paint.Style.FILL);
                mRect.set(x, y, x + cellWidth, y + cellWidth);
                canvas.drawBitmap(mBitmaps[piece.getSymbol().ordinal()], null, mRect, mPaint);
            }

            if(mShowMargin && i == 0) {
                x = margin + j * cellWidth + cellWidthHalf;
                final int topMargin = (int)((margin - cellAscent) / 2.0 + 0.5f);
                final int bottomMargin = (mWidth - margin) + topMargin + 4;

                mPaint.setColor(Color.BLACK);

                final int fileIndex = getWhitePlayer() ? j : mFiles.length - j - 1;
                canvas.drawText(mFiles, fileIndex, 1, x, topMargin, mPaint);
                canvas.drawText(mFiles, fileIndex, 1, x, bottomMargin, mPaint);

                final int halfMargin = (int)(margin / 2.0 + 0.5f);
                y = margin + j * cellWidth + cellCenterOffset + strokeWidth;

                final int rankIndex = getWhitePlayer() ? mRanks.length - j - 1 : j;
                canvas.drawText(mRanks, rankIndex, 1, halfMargin, y, mPaint);
                canvas.drawText(mRanks, rankIndex, 1, margin + 8 * cellWidth + 2 * strokeWidth + halfMargin, y, mPaint);
            }

            current++;
        }

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.GRAY);
        canvas.drawRect(margin, margin, margin + 8 * cellWidth + 2 * strokeWidth,
                margin + 8 * cellWidth + 2 * strokeWidth, mPaint);
    }

    public void setFen(String fen) {
        mBoardPosition = new Fen("rnbqkbnr/pp1ppppp/8/2p5/4P3/5N2/PPPP1PPP/RNBQKB1R b KQkq - 1 2");
    }

    public String getFen() {
        return mBoardPosition.toString();
    }

    public void setShowMargin(boolean showMargin) {
        mShowMargin = showMargin;
    }

    public boolean getShowMargin() {
        return mShowMargin;
    }

    public boolean getWhitePlayer() {
        return mWhitePlayer;
    }

    public void setWhitePlayer(boolean whitePlayer) {
        mWhitePlayer = whitePlayer;
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mScale = getContext().getResources().getDisplayMetrics().density;

        Rect bounds = new Rect();
        mPaint.getTextBounds("Hello Worly!", 0, 12, bounds);
        mLetterBoundHeight = (int)(bounds.height() * mScale + 0.5f);

        mPaint.getTextBounds("12345678", 0, 8, bounds);
        mLetterBoundWidth = (int) ((bounds.width() * mScale) / 8.0 + 0.5f);

        mWidth = (int)(WIDTH * mScale + 0.5f);
        
        preloadBitmaps();
    }

    private void preloadBitmaps() {
        final int[] resourceIds = {
                R.drawable.black_king,
                R.drawable.black_queen,
                R.drawable.black_rook,
                R.drawable.black_bishop,
                R.drawable.black_knight,
                R.drawable.black_pawn,
                R.drawable.white_king,
                R.drawable.white_queen,
                R.drawable.white_rook,
                R.drawable.white_bishop,
                R.drawable.white_knight,
                R.drawable.white_pawn
        };

        for(int i = 0; i < resourceIds.length; ++i) {
            mBitmaps[i] = BitmapFactory.decodeResource(getResources(), resourceIds[i]);
        }
    }
}
