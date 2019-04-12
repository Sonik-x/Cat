public class Loader
{
    public static void main(String[] args)
    {
        Cat tantan = new Cat();
        Cat tripper = new Cat();
        Cat noor = new Cat();
        Cat tioma = new Cat();
        Cat vasya = new Cat();

        var cats = new Cat[]{tantan, tripper, noor, tioma, vasya };

        Cat.printAllCatsWeight(cats);
        Cat.feedAllCats(cats);
        Cat.printAllCatsWeight(cats);

        while (noor.getAlive()){
            noor.feed(200.0 * Math.random());
            //System.out.println(noor.getWeight() + " ");
        }

        /* while (tripper.checkAlive()){
            tripper.meow();
        } */

        noor.toilet();

        var murka = new Cat(2000.0);
        System.out.println(murka.originWeight);
        System.out.println(murka.getColour());

        System.out.println(Cat.getCount());
        var catty = createACat(4000.0);
        System.out.println(catty.originWeight);
        System.out.println(Cat.getCount());
        System.out.println(catty.getColour());

        int a = (int)(5*Math.random());











    }

    public static Cat createACat(double weight){
        return new Cat(weight);
    }
}