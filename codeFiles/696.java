for (int i = 0; i <= myArray.Length; i++){if (i == 0) p.ID = myArray[i];if (i == 1) p.Name = myArray[i];if (i == 2) p.Age = myArray[i];if (i!=0 && i % 2 == 0){    if (myArray.Length > 0)    {        myArray = myArray.Skip(3).ToArray();    }    i = 0;}}