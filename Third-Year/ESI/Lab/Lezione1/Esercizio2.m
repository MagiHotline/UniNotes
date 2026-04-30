
count = 0;
for i = 1:10000
    x = randn(1,1); % Generate a new random number
    y = -1 <= x && x <= 1; % Check if x is within the range
    if(y)
        % Perform some action if x is within the range
        % For example, count the number of valid x values
        count = count + 1;
    end 
end

% Senza cicli
x = randn(1,10000);
idx = x <= 1 & x >= -1;
z = sum(idx)
