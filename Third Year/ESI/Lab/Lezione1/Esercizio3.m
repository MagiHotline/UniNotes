function [output] = Mymean (input)
    x = size(input)
    if x(1,1) == 1 || x(1,2) == 1
        output = sum(input) / numel(input);
    else
        for i = 1:x
            output(i) = sum(input(:, i)) / numel(input(:, i));
        end 
    end
    
end

vec = [1:2:30];
vec_media = Mymean(vec);
media_matlab = mean(vec);
confronto = [vec_media ; media_matlab]

mat = [1 2 3 ; 4 5 6 ; 7 8 9]

mat_media = Mymean(mat)

