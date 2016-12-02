// define a grammar called Hello
grammar Fen;

@header {

package com.dezelin.parsers;

}

fen:
    piecePlacement ' '
    sideToMove ' '
    castlingAbility ' '
    enPassantTargetSquare ' '
    halfMoveClock ' '
    fullMoveCounter
    EOF;

piecePlacement:
    rank '/'
    rank '/'
    rank '/'
    rank '/'
    rank '/'
    rank '/'
    rank '/'
    rank;

rank: skipNumber? piece (skipNumber? piece)* skipNumber? | skipAll;

skipNumber: '1' | '2' | '3' | '4' | '5' | '6' | '7';

skipAll: '8';

piece: blackPiece | whitePiece;

blackPiece: 'p' | 'n' | 'b' | 'r' | 'q' | 'k';

whitePiece: 'P' | 'N' | 'B' | 'R' | 'Q' | 'K';

sideToMove: 'w' | 'b';

castlingAbility: '-' | 'K'? 'Q'? 'k'? 'q'?;

enPassantTargetSquare: '-' | epSquare;

epSquare: fileLetter epRank;

fileLetter: 'a' | 'b' | 'c' | 'd' | 'e' | 'f' | 'g' | 'h';

epRank: '3' | '6';

halfMoveClock: ('0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9')+;

fullMoveCounter:
    ('1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9')
    ('0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9')*;

// All token recognition errors whill go through parser
// so we can catch them as ParseCancellationException exceptions.
ErrorCharacter : . ;

