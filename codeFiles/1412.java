boolean[] explored = new boolean[H*W]; // <- put this line after the 2 for-loops...if (explored[py*H+px]) {...explored[py*H+px] = true;...int index = 0;for(int y=0; y<H; y++){    for(int x=0; x<W; x++){        if(explored[index]){            System.out.println(x + &quot; &quot; + y);        }        index++;    }}