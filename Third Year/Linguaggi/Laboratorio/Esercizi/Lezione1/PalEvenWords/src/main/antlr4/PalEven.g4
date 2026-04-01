grammar PalEven;

main: pal EOF;
pal: | '0' pal '0' | '1' pal '1';
