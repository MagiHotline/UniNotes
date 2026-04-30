% Corso di Elaborazione dei Segnali e Immagini
% Docente: Manuele Bicego 
% Lezione 5: Esercizi principali 


%% Esempio 1 - SINUSOIDE A 20 Hz 1-D CAMPIONATA A 100 Hz 
% Obiettivo di questo esempio è mostrare come si possono
% generare segnali e controllarne lo spettro. In particolare,
% si definisce una sinusoide a 20 Hz, si campiona a 100Hz e si osserva lo 
% spettro di magnitudo con picco a 20 Hz. 
% Controllare anche lo spettro di fase.


clear all
close all
clc

% FUNZIONI RICHIESTE: fft, fftshift, abs, angle

% Definisco le principali variabili di interesse e il segnale 
mu = 20;        % frequenza del segnale sinusoidale
mu_s = 100;     % frequenza di campionamento 
Dt = 1/mu_s;    % delta T: un campione ogni delta_T
t = -0.5:Dt:0.5-Dt;  % prendo un secondo di durata
N = length(t);  % numero di campioni

f = sin(2*pi*mu*t); % segnale sinusoidale

figure
subplot(221)
plot(t,f,'-b.','MarkerSize',9)
xlabel ('tempo (sec.)')
ylabel ('f(t)')
title('Segnale campionato');

% Calcolo la trasformata di Fourier e definisco il vettore delle frequenze
F = fft(f);           % Fast Fourier Transform è l'implementazione della DFT
% Se il segnale originale ha N punti ho N bin in frequenza: 
% da 0 alla frequenza di campionamento (mu_s - step) con step mu_s/N
mu_sampling = mu_s/N; % passo
mu = 0:mu_sampling:mu_s-mu_sampling; % campioni nello spazio delle frequenze

subplot(222)
stem(mu,abs(F));
xlabel ('frequenza (Hz)')
ylabel ('|F|')
grid
title('DFT (abs) senza riordinamento');

% Eseguo operazione di centratura dello spettro e visualizzo spettro centrato
Fs = fftshift(F); % centratura 
mu_max = mu_s/2;  % frequenza di Nyquist ? 
mu = -mu_max:mu_sampling:mu_max-mu_sampling; % nuovo vettore frequenze 

subplot(223)
stem(mu,abs(Fs))
xlabel ('frequenza (Hz)')
ylabel ('|Fs|')
grid
title('DFT (abs) con riordinamento');

% Eseguo pulizia per eliminare le componenti con magnitudo bassa e calcolo la fase 
th = 1e-6;
Fs(abs(Fs) < th) = 0; 

subplot(224)
stem(mu,angle(Fs)/pi) % Posso moltiplicare per 180 per avere gradi 
xlabel ('frequenza (Hz)')
ylabel ('fase/\pi')
grid
title('DFT (fase) con riordinamento');


%%%%%%%% RIASSUNTO:
% Passi:
% calcolo il vettore dei tempi e delle frequenze (N valori da -mu_s/2 a mu_s/2 -step)
% calcolo la fft e la fft riordinata
% calcolo il vettore frequenze: 
%       fft riordinata: (N valori da -mu_s/2 a mu_s/2-step)
%       fft non riordinata: (N valori da 0 a mu_s-step)
%       step = mu_s/N
% visualizzo lo spettro di ampiezza
% Se segnale rumoroso: pulisco lo spettro e tolgo le frequenze troppo basse
% visualizzo lo spettro di fase
%%%%%%%%%%%%%%%%%%%


%%%%%%%%%%%%%%%%%%%%%%%
% Altro esempio con il seguente segnale: 
% f = cos(2*pi*10*t) - sin(2*pi*40*t)
% cosa ottengo?

f = cos(2*pi*10*t) - sin(2*pi*40*t); % segnale sinusoidale

figure
subplot(221)
plot(t,f,'-b.','MarkerSize',9)
xlabel ('tempo (sec.)')
ylabel ('f(t)')
title('Segnale campionato');

% Calcolo la trasformata di Fourier e definisco il vettore delle frequenze
F = fft(f);           % Fast Fourier Transform è l'implementazione della DFT
mu_sampling = mu_s/N; % passo
mu = 0:mu_sampling:mu_s-mu_sampling; % campioni nello spazio delle frequenze

subplot(222)
stem(mu,abs(F));
xlabel ('frequenza (Hz)')
ylabel ('|F|')
grid
title('DFT (abs) senza riordinamento');

% Eseguo operazione di centratura dello spettro e visualizzo spettro centrato
Fs = fftshift(F); % centratura 
mu_max = mu_s/2;  % frequenza di Nyquist ? 
mu = -mu_max:mu_sampling:mu_max-mu_sampling; % nuovo vettore frequenze 

subplot(223)
stem(mu,abs(Fs))
xlabel ('frequenza (Hz)')
ylabel ('|Fs|')
grid
title('DFT (abs) con riordinamento');

% Eseguo pulizia per eliminare le componenti con magnitudo bassa e calcolo la fase 
th = 1e-6;
Fs(abs(Fs) < th) = 0; 

subplot(224)
stem(mu,angle(Fs)/pi) % Posso moltiplicare per 180 per avere gradi 
xlabel ('frequenza (Hz)')
ylabel ('fase/\pi')
grid
title('DFT (fase) con riordinamento');




%% Esercizio 1
% Analizzare tramite la Trasformata di Fourier Discreta  un segnale BOX
%   - Creare un'onda rettangolare di 1 secondo con una frequenza di 
%     campionamento di 500 Hz e una lunghezza di 0.2 s 
%     (funzione rectpuls – si veda l’help)
%   - Calcolare la DFT e visualizzarne lo spettro di ampiezza e di fase 
%     (con riordinamento)
%   - Controllare che il risultato ottenuto per lo spettro di ampiezza 
%     corrisponda a quanto spiegato in teoria
%
% (se si vuole): Provare ad effettuare la stessa analisi su un segnale audio 
% registrato direttamente in MATLAB, della durata di 4 secondi
% (si veda la seconda lezione)

% Funzione BoX

clear all
close all

% Fissare la frequenza di campionamento e la lunghezza del box
% Generare il vettore dei tempi: 
%    - 1 secondo di lunghezza, centrato nello zero
%    - il deltaT si ricava dalla frequenza di campionamento
% Utilizzare rectpuls
% 
% ...

mu_s = 500;
Dt = 1/mu_s;
t = -0.5:Dt:0.5; % Un secondo di lunghezza centrato nello zero
N = length(t); % Lunghezza di t
f = rectpuls(t, 0.2); % Crea un'onda rettangolare di lunghezza 0.2 s

figure
subplot(221)

plot(t,f,'-b.','MarkerSize',9)
xlabel ('tempo (sec.)')
ylabel ('f(t)')
title('Segnale campionato');

% Calcolo la trasformata di Fourier e definisco il vettore delle frequenze
F = fft(f);           % Fast Fourier Transform è l'implementazione della DFT
mu_sampling = mu_s/N; % step

% Eseguo operazione di centratura dello spettro e visualizzo spettro centrato
Fs = fftshift(F); % centratura 
mu_max = mu_s/2;  % frequenza di Nyquist ? 
mu = -mu_max : mu_sampling : mu_max - mu_sampling; % nuovo vettore frequenze 

subplot(222)
stem(mu, abs(F));
xlabel ('frequenza (Hz)')
ylabel ('|F|')
grid
title('DFT (abs) con riordinamento');

% Eseguo pulizia per eliminare le componenti con magnitudo bassa e calcolo la fase 
th = 1e-6;
Fs(abs(Fs) < th) = 0; 

subplot(223)
stem(mu, angle(Fs)/pi) % Posso moltiplicare per 180 per avere gradi 
xlabel ('frequenza (Hz)')
ylabel ('fase/\pi')
grid
title('DFT (fase) con riordinamento');


%% Esercizio 2
% Verificare il fenomeno dell'aliasing.
% In particolare: 
% - partire dal segnale sinusoidale sin(2*pi*fsig*t), dove fsig = 10 è la
%   frequenza del segnale
% - campionare un secondo di segnale ad una determinata frequenza ed effettuare
%   l'analisi di Fourier
% - Provare con le seguenti frequenze: 
%  [200, 100, 40, 30, 20, 15, 10]
% Per quali di queste avviene il fenomeno dell'aliasing?
% E' corretto rispetto alla teoria?

clear all
close all
clc

% creo il segnale campionato con frequenza Fs
% Suggerimento:
% Fisso Fs
% Calcolo DeltaT (1/Fs)
% Creo un vettore t per i tempi (1 secondo) con passo DeltaT
% creo il segnale con fsig = 10
% y = sin(2*pi*fsig*t);

fsig = 10;
mu_s = 20; % Frequenze da cambiare
Dt = 1/mu_s; % Calcolo DeltaT
t = 0:Dt:1-Dt; % Creo un vettore t per i tempi (1 secondo)
y = sin(2*pi*fsig*t); % Creo il segnale sinusoidale
N = length(t);

figure
subplot(221)

plot(t,y,'-b.','MarkerSize',9)
xlabel ('tempo (sec.)')
ylabel ('f(t)')
title('Segnale campionato');

Y = fft(y); % Calcoliamo la DFT
Fs = fftshift(Y); % centratura 
mu_sampling = mu_s/N; % passo
mu_max = mu_s/2;  % frequenza di Nyquist 
mu = -mu_max:mu_sampling:mu_max-mu_sampling; % nuovo vettore frequenze 

subplot(222)
stem(mu, abs(Y));
xlabel ('frequenza (Hz)')
ylabel ('|F|')
grid
title('DFT (abs) con riordinamento');

% Eseguo pulizia per eliminare le componenti con magnitudo bassa e calcolo la fase 
th = 1e-6;
Fs(abs(Fs) < th) = 0; 

subplot(223)
stem(mu, angle(Fs)/pi) % Posso moltiplicare per 180 per avere gradi 
xlabel ('frequenza (Hz)')
ylabel ('fase/\pi')
grid
title('DFT (fase) con riordinamento');
%% Esercizio 3
% Caricare il segnale in Voice.mat (f è il segnale, fs la
% frequenza di campionamento)
% Effettuare un'analisi di Fourier (calcolare e visualizzare lo
% spettro di ampiezza)
% Operare un sottocampionamento
% Suggerimento: per fare sottocampionamento con
% fattore D si può prendere solo un sottoinsieme di punti,
% uno ogni D
% Exe: f segnale originale, f(1:2:end) segnale in cui prendo
% punto ogni due (cioè con un fattore di
% sottocampioamento D=2)
% La frequenza di campionamento corrispondente è fs/D

clear all
close all
clc

load("/Users/paoloimbriani/Desktop/UniNotes/Third Year/ESI/Lab/Lezione5/Voice.mat")

N = length(f); % Numero di campioni nel segnale

F = fft(f);
Fs = fftshift(F);

% L'asse va da -fs/2 a +fs/2
% df è la risoluzione in frequenza
df = fs / N; 
mu = (-N/2 : N/2 - 1) * df;

figure
subplot(222)
stem(mu, abs(Fs));
xlabel ('frequenza (Hz)')
ylabel ('|F|')
grid on
title('DFT (abs) con riordinamento');

% Pulizia Fase e Plot
th = 1e-6; % Soglia di tolleranza
Fs_clean = Fs;
Fs_clean(abs(Fs) < th) = 0; % Azzero il rumore numerico

subplot(223)
stem(mu, angle(Fs_clean)/pi) 
xlabel('Frequenza (Hz)')
ylabel('Fase / \pi')
grid on
title('Spettro di Fase');

% Sottocampionamento

D = 14; % > 14 ci sta ALIASING
f_sampled = f(1:D:end);
freq_camp = fs / D;
N = length(f_sampled);

% Calcolo la trasformata di Fourier del segnale sottocampionato
F_sampled = fft(f_sampled);
Fs_sampled = fftshift(F_sampled);

step = freq_camp / N; % step
mu_max = freq_camp / 2; % frequenza di Nyquist
mu = -mu_max : step : mu_max - step;

figure 
subplot(222)
stem(mu, abs(F_sampled));
xlabel ('frequenza (Hz)')
ylabel ('|F|')
grid
title('DFT (abs) con riordinamento');

