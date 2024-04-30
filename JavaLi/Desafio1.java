// import java.lang.reflect.Array;
public class Desafio1 {
    public static void main(String[] args)
    {
        int[] array = new int[]
        {
            244, 232, 241, 123,
            232, 064, 111, 140
        };
        
        int[] result = compact(array);
        for(int i = 0; i < result.length; i++)
            System.out.printf("%d ", result[i]);
        int[] result2 = decompact(result);
        for(int i = 0; i < result2.length; i++)
            System.out.printf("\n%d", result2[i]);
    }
    
    static int[] compact(int[] originalData)
    {
        int[] listaNova = new int[originalData.length/2];
        int j = 0;
        for(int i = 0; i < originalData.length; i += 2)
        {
            listaNova[j] = ((originalData[i] >> 4) << 4) + (originalData[i+1] >> 4);
            j ++;
        }
        return listaNova;
    }
    static int[] decompact(int[] originalData)
    {
        int j = 0;
        int[] descompactado = new int[originalData.length*2];
        for(int i = 0;i < originalData.length; i ++)
        {
            descompactado[j] = originalData[i] & 240;
            j ++;
            descompactado[j] = (originalData[i] & 15) << 4;
            j ++;
        }
        return descompactado;
    }
}
