namespace PRV2;

public class MainClass
{
    private static Program _program;
    public static void Main(string[] args)
    {
        _program = Program.Get();
        _program.Run();
    }
}
