figure;
paperino = imread('paperino.jpeg');
paperino_glasses = paperino;
paperino_glasses(160:210, 100:200, :) = 0;
paperino_rotated = imrotate(paperino, 45);

subplot(2,2,1);
imshow(paperino);
title("Immagine Originale")

subplot(2,2,2);
imshow(paperino_glasses);
title("Immagine Modificata")

subplot(2,2,3);
imshow(paperino_rotated);
title("Immagine ruotata");
