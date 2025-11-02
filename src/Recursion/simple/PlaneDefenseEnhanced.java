package Recursion.simple;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.*;

public class PlaneDefenseEnhanced extends JPanel implements KeyListener, ActionListener {

    // Game states
    enum GameState { MENU, PLAYING, PAUSED, GAME_OVER, SHOP }
    GameState gameState = GameState.MENU;

    // Enhanced Enemy class
    class Enemy {
        Point position;
        int type; // 0=normal, 1=fast, 2=zigzag, 3=boss
        int health;
        int zigzagCounter = 0;
        
        Enemy(Point pos, int t) {
            position = pos;
            type = t;
            health = (t == 3) ? 5 : 1;
        }
    }

    // Power-up class
    class PowerUp {
        Point position;
        int type; // 0=rapid fire, 1=shield, 2=multi-shot, 3=life
        int timer = 0;
        
        PowerUp(Point pos, int t) {
            position = pos;
            type = t;
        }
    }

    // Particle class for effects
    class Particle {
        Point position;
        Point velocity;
        Color color;
        int life;
        
        Particle(Point pos, Color c) {
            position = new Point(pos);
            velocity = new Point((int)(Math.random() * 6 - 3), (int)(Math.random() * 6 - 3));
            color = c;
            life = 30;
        }
    }

    // Player
    int playerX;
    final int PLAYER_Y = 350;
    final int PLAYER_WIDTH = 30;
    final int PLAYER_HEIGHT = 10;
    final int PLAYER_SPEED = 20;
    boolean leftPressed = false;
    boolean rightPressed = false;
    boolean spacePressed = false;

    // Game objects
    List<Enemy> enemies = new ArrayList<>();
    List<Point> missiles = new ArrayList<>();
    List<PowerUp> powerUps = new ArrayList<>();
    List<Particle> particles = new ArrayList<>();
    List<Point> backgroundStars = new ArrayList<>();
    List<Integer> starDepths = new ArrayList<>();

    // Weapon system
    int weaponLevel = 1;
    final int MAX_WEAPON_LEVEL = 3;
    int autoMissileCooldown = 0;
    final int MAX_MANUAL_MISSILE_COOLDOWN = 15;
    int manualMissileCooldown = 0;
    boolean rapidFireActive = false;
    int rapidFireTimer = 0;
    boolean multiShotActive = false;
    int multiShotTimer = 0;
    boolean shieldActive = false;
    int shieldTimer = 0;

    // Game stats
    int lives = 3;
    int score = 0;
    int highScore = 0;
    int level = 1;
    int currentWave = 1;
    int enemiesInWave = 8;
    int enemiesSpawnedThisWave = 0;
    boolean waveInProgress = false;
    int waveCooldown = 0;
    boolean isInvulnerable = false;
    int invulnerabilityTimer = 0;
    int combo = 0;
    int comboMultiplier = 1;
    int comboTimeout = 0;
    final int COMBO_TIME_LIMIT = 120;
    int currency = 0;
    int bossSpawnCounter = 0;

    Timer timer;

    public PlaneDefenseEnhanced() {
        JFrame frame = new JFrame("Plane Defense - Ultimate Edition");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.addKeyListener(this);
        frame.setVisible(true);

        playerX = frame.getWidth() / 2 - PLAYER_WIDTH / 2;
        timer = new Timer(50, this);
        
        initializeBackground();
        loadHighScore();
    }

    private void initializeBackground() {
        for (int i = 0; i < 80; i++) {
            backgroundStars.add(new Point((int)(Math.random() * getWidth()), 
                                         (int)(Math.random() * getHeight())));
            starDepths.add((int)(Math.random() * 3) + 1);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);

        drawBackground(g);

        switch (gameState) {
            case MENU:
                drawMenu(g);
                break;
            case PLAYING:
                drawGame(g);
                break;
            case PAUSED:
                drawGame(g);
                drawPauseScreen(g);
                break;
            case GAME_OVER:
                drawGame(g);
                drawGameOverScreen(g);
                break;
            case SHOP:
                drawGame(g);
                drawShopScreen(g);
                break;
        }
    }

    private void drawBackground(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        for (int i = 0; i < backgroundStars.size(); i++) {
            Point star = backgroundStars.get(i);
            int size = starDepths.get(i);
            g.fillRect(star.x, star.y, size, size);
        }
    }

    private void drawMenu(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("PLANE DEFENSE ULTIMATE", 80, 150);
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.drawString("Press ENTER to Start", 160, 200);
        g.drawString("Arrow Keys = Move", 160, 230);
        g.drawString("SPACE = Manual Fire", 160, 260);
        g.drawString("P = Pause Game", 160, 290);
        g.drawString("High Score: " + highScore, 180, 330);
    }

    private void drawGame(Graphics g) {
        // Draw particles
        for (Particle p : particles) {
            float alpha = (float)p.life / 30.0f;
            Color particleColor = new Color(p.color.getRed(), p.color.getGreen(), p.color.getBlue(), (int)(alpha * 255));
            g.setColor(particleColor);
            g.fillRect(p.position.x, p.position.y, 4, 4);
        }

        // Draw power-ups
        for (PowerUp pu : powerUps) {
            switch (pu.type) {
                case 0: g.setColor(Color.CYAN); break;
                case 1: g.setColor(Color.BLUE); break;
                case 2: g.setColor(Color.MAGENTA); break;
                case 3: g.setColor(Color.GREEN); break;
            }
            g.fillRect(pu.position.x, pu.position.y, 15, 15);
            g.setColor(Color.WHITE);
            g.drawRect(pu.position.x, pu.position.y, 15, 15);
        }

        // Draw enemies
        for (Enemy enemy : enemies) {
            switch (enemy.type) {
                case 0: g.setColor(Color.RED); break;
                case 1: g.setColor(Color.ORANGE); break;
                case 2: g.setColor(Color.PINK); break;
                case 3: g.setColor(Color.MAGENTA); break;
            }
            g.fillOval(enemy.position.x, enemy.position.y, 20, 20);
            g.setColor(Color.WHITE);
            g.drawOval(enemy.position.x, enemy.position.y, 20, 20);
            
            // Draw health bar for boss
            if (enemy.type == 3) {
                g.setColor(Color.RED);
                g.fillRect(enemy.position.x, enemy.position.y - 5, 20, 3);
                g.setColor(Color.GREEN);
                g.fillRect(enemy.position.x, enemy.position.y - 5, enemy.health * 4, 3);
            }
        }

        // Draw missiles
        g.setColor(Color.YELLOW);
        for (Point missile : missiles) {
            g.fillRect(missile.x, missile.y, 5, 10);
        }

        // Draw player
        if (shieldActive) {
            g.setColor(new Color(0, 255, 255, 100));
            g.fillOval(playerX - 5, PLAYER_Y - 5, PLAYER_WIDTH + 10, PLAYER_HEIGHT + 20);
        }
        
        if (isInvulnerable && invulnerabilityTimer % 10 < 5) {
            g.setColor(Color.CYAN);
        } else {
            g.setColor(Color.GREEN);
        }
        g.fillRect(playerX, PLAYER_Y, PLAYER_WIDTH, PLAYER_HEIGHT);
        g.setColor(Color.WHITE);
        g.fillRect(playerX + PLAYER_WIDTH/2 - 2, PLAYER_Y - 5, 4, 5);

        drawHUD(g);
    }

    private void drawHUD(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        
        // Top HUD
        g.drawString("Score: " + score, 10, 20);
        g.drawString("High Score: " + highScore, 120, 20);
        g.drawString("Level: " + level, 250, 20);
        g.drawString("Wave: " + currentWave, 320, 20);
        g.drawString("Weapon: " + getWeaponName(), 400, 20);
        
        // Stats HUD
        g.drawString("Lives: " + lives, 10, 40);
        g.drawString("Combo: x" + comboMultiplier, 120, 40);
        g.drawString("Currency: $" + currency, 250, 40);
        
        // Cooldown indicator
        if (manualMissileCooldown > 0) {
            g.setColor(Color.GRAY);
            g.drawString("Reloading: " + (manualMissileCooldown/3 + 1), 400, 40);
        } else {
            g.setColor(Color.GREEN);
            g.drawString("Ready to Fire!", 400, 40);
        }
        
        // Power-up timers
        int timerY = 60;
        if (rapidFireActive) {
            g.setColor(Color.CYAN);
            g.drawString("Rapid Fire: " + (rapidFireTimer/20 + 1), 10, timerY);
            timerY += 15;
        }
        if (multiShotActive) {
            g.setColor(Color.MAGENTA);
            g.drawString("Multi-Shot: " + (multiShotTimer/20 + 1), 10, timerY);
            timerY += 15;
        }
        if (shieldActive) {
            g.setColor(Color.BLUE);
            g.drawString("Shield: " + (shieldTimer/20 + 1), 10, timerY);
        }
        
        // Health bar
        g.setColor(Color.RED);
        g.fillRect(10, getHeight() - 30, 100, 10);
        g.setColor(Color.GREEN);
        g.fillRect(10, getHeight() - 30, lives * 33, 10);
        g.setColor(Color.WHITE);
        g.drawRect(10, getHeight() - 30, 100, 10);
        
        // Wave info
        if (waveInProgress) {
            g.setColor(Color.ORANGE);
            g.drawString("Enemies: " + (enemiesInWave - enemiesSpawnedThisWave) + " / " + enemiesInWave, 
                         getWidth()/2 - 60, 60);
        } else if (waveCooldown > 0) {
            g.setColor(Color.YELLOW);
            g.drawString("Next Wave: " + (waveCooldown/20 + 1), getWidth()/2 - 40, 60);
        }
    }

    private void drawPauseScreen(Graphics g) {
        g.setColor(new Color(0, 0, 0, 180));
        g.fillRect(0, 0, getWidth(), getHeight());
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("GAME PAUSED", 160, 150);
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.drawString("Press P to Resume", 170, 200);
    }

    private void drawGameOverScreen(Graphics g) {
        g.setColor(new Color(0, 0, 0, 180));
        g.fillRect(0, 0, getWidth(), getHeight());
        
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("GAME OVER", 180, 150);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.drawString("Final Score: " + score, 190, 190);
        g.drawString("Wave Reached: " + currentWave, 190, 210);
        g.drawString("Press ENTER to Restart", 170, 250);
    }

    private void drawShopScreen(Graphics g) {
        g.setColor(new Color(0, 0, 0, 180));
        g.fillRect(0, 0, getWidth(), getHeight());
        
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("UPGRADE SHOP", 160, 100);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.drawString("Currency: $" + currency, 190, 130);
        g.drawString("1 - Upgrade Weapon ($50) - Level " + weaponLevel, 120, 180);
        g.drawString("2 - Buy Life ($30)", 120, 210);
        g.drawString("3 - Rapid Fire Power-up ($40)", 120, 240);
        g.drawString("ENTER - Start Next Wave", 120, 270);
    }

    private String getWeaponName() {
        switch (weaponLevel) {
            case 1: return "Basic";
            case 2: return "Spread";
            case 3: return "Laser";
            default: return "Basic";
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateBackground();
        
        if (gameState != GameState.PLAYING) return;

        updatePlayer();
        updateWeapons();
        updateEnemies();
        updatePowerUps();
        updateParticles();
        updateWaveSystem();
        updateComboSystem();
        updatePowerUpTimers();
        checkCollisions();

        if (lives <= 0) {
            endGame();
        }

        repaint();
    }

    private void updateBackground() {
        for (int i = 0; i < backgroundStars.size(); i++) {
            Point star = backgroundStars.get(i);
            star.y += starDepths.get(i);
            if (star.y > getHeight()) {
                star.y = 0;
                star.x = (int)(Math.random() * getWidth());
            }
        }
    }

    private void updatePlayer() {
        if (leftPressed && playerX > 0) playerX -= PLAYER_SPEED;
        if (rightPressed && playerX < getWidth() - PLAYER_WIDTH) playerX += PLAYER_SPEED;
    }

    private void updateWeapons() {
        // Auto fire
        int fireRate = rapidFireActive ? 3 : 8;
        autoMissileCooldown++;
        if (autoMissileCooldown >= fireRate) {
            fireMissile();
            autoMissileCooldown = 0;
        }

        // Manual fire
        if (spacePressed && manualMissileCooldown <= 0) {
            fireMissile();
            manualMissileCooldown = MAX_MANUAL_MISSILE_COOLDOWN;
        }
        if (manualMissileCooldown > 0) manualMissileCooldown--;

        // Move missiles
        Iterator<Point> missileIt = missiles.iterator();
        while (missileIt.hasNext()) {
            Point missile = missileIt.next();
            missile.y -= 12;
            if (missile.y < 0) missileIt.remove();
        }
    }

    private void fireMissile() {
        switch (weaponLevel) {
            case 1: // Single shot
                missiles.add(new Point(playerX + PLAYER_WIDTH/2 - 2, PLAYER_Y - 10));
                break;
            case 2: // Spread shot
                missiles.add(new Point(playerX + PLAYER_WIDTH/2 - 2, PLAYER_Y - 10));
                missiles.add(new Point(playerX + PLAYER_WIDTH/4 - 2, PLAYER_Y - 10));
                missiles.add(new Point(playerX + 3*PLAYER_WIDTH/4 - 2, PLAYER_Y - 10));
                break;
            case 3: // Laser (wider missile)
                Point laser = new Point(playerX + PLAYER_WIDTH/2 - 5, PLAYER_Y - 15);
                laser.y -= 5; // Start higher
                missiles.add(laser);
                break;
        }
        playBeep(440, 50); // Shooting sound
    }

    private void updateEnemies() {
        Iterator<Enemy> enemyIt = enemies.iterator();
        while (enemyIt.hasNext()) {
            Enemy enemy = enemyIt.next();
            
            // Movement patterns
            switch (enemy.type) {
                case 0: // Normal
                    enemy.position.y += 3 + (level / 3);
                    break;
                case 1: // Fast
                    enemy.position.y += 6 + (level / 3);
                    break;
                case 2: // Zigzag
                    enemy.position.y += 2 + (level / 3);
                    enemy.zigzagCounter++;
                    enemy.position.x += (int)(Math.sin(enemy.zigzagCounter * 0.3) * 3);
                    break;
                case 3: // Boss
                    enemy.position.y += 1;
                    enemy.zigzagCounter++;
                    enemy.position.x += (int)(Math.sin(enemy.zigzagCounter * 0.1) * 2);
                    break;
            }
            
            // Keep within bounds
            if (enemy.position.x < 0) enemy.position.x = 0;
            if (enemy.position.x > getWidth() - 20) enemy.position.x = getWidth() - 20;
            
            // Remove if out of bounds
            if (enemy.position.y > getHeight()) {
                enemyIt.remove();
            }
        }
    }

    private void updatePowerUps() {
        Iterator<PowerUp> powerUpIt = powerUps.iterator();
        while (powerUpIt.hasNext()) {
            PowerUp pu = powerUpIt.next();
            pu.position.y += 2;
            pu.timer++;
            
            // Remove if off screen or timed out
            if (pu.position.y > getHeight() || pu.timer > 600) {
                powerUpIt.remove();
            }
        }
    }

    private void updateParticles() {
        Iterator<Particle> particleIt = particles.iterator();
        while (particleIt.hasNext()) {
            Particle p = particleIt.next();
            p.position.x += p.velocity.x;
            p.position.y += p.velocity.y;
            p.life--;
            
            if (p.life <= 0) {
                particleIt.remove();
            }
        }
    }

    private void updateWaveSystem() {
        if (!waveInProgress && enemies.isEmpty()) {
            waveCooldown--;
            if (waveCooldown <= 0) {
                startNextWave();
            }
        }

        if (waveInProgress && enemiesSpawnedThisWave < enemiesInWave) {
            if (Math.random() < 0.08) {
                spawnEnemyForWave();
                enemiesSpawnedThisWave++;
            }
        }

        if (waveInProgress && enemies.isEmpty() && enemiesSpawnedThisWave >= enemiesInWave) {
            completeWave();
        }
    }

    private void startNextWave() {
        waveInProgress = true;
        enemiesSpawnedThisWave = 0;
        enemiesInWave = 8 + (currentWave * 2);
        waveCooldown = 0;
    }

    private void completeWave() {
        waveInProgress = false;
        waveCooldown = 180;
        currency += currentWave * 15;
        currentWave++;
        
        if (currentWave % 3 == 0) {
            level++;
        }
        
        // Every 5 waves, go to shop
        if (currentWave % 5 == 1 && currentWave > 1) {
            gameState = GameState.SHOP;
        }
    }

    private void spawnEnemyForWave() {
        int x = (int)(Math.random() * (getWidth() - 20));
        int enemyType;
        
        if (currentWave >= 10 && Math.random() < 0.1) {
            enemyType = 3; // Boss
        } else if (currentWave >= 7 && Math.random() < 0.3) {
            enemyType = 2; // Zigzag
        } else if (currentWave >= 4 && Math.random() < 0.4) {
            enemyType = 1; // Fast
        } else {
            enemyType = 0; // Normal
        }
        
        enemies.add(new Enemy(new Point(x, -20), enemyType));
    }

    private void updateComboSystem() {
        if (comboTimeout > 0) {
            comboTimeout--;
        } else {
            combo = 0;
            comboMultiplier = 1;
        }
    }

    private void updatePowerUpTimers() {
        if (rapidFireActive) {
            rapidFireTimer--;
            if (rapidFireTimer <= 0) {
                rapidFireActive = false;
            }
        }
        
        if (multiShotActive) {
            multiShotTimer--;
            if (multiShotTimer <= 0) {
                multiShotActive = false;
            }
        }
        
        if (shieldActive) {
            shieldTimer--;
            if (shieldTimer <= 0) {
                shieldActive = false;
            }
        }
        
        if (isInvulnerable) {
            invulnerabilityTimer--;
            if (invulnerabilityTimer <= 0) {
                isInvulnerable = false;
            }
        }
    }

    private void checkCollisions() {
        // Missile-Enemy collisions
        Iterator<Point> missileIt = missiles.iterator();
        while (missileIt.hasNext()) {
            Point missile = missileIt.next();
            Iterator<Enemy> enemyIt = enemies.iterator();
            boolean missileUsed = false;
            
            while (enemyIt.hasNext() && !missileUsed) {
                Enemy enemy = enemyIt.next();
                if (missile.x + 2 >= enemy.position.x && missile.x <= enemy.position.x + 18 &&
                    missile.y >= enemy.position.y && missile.y <= enemy.position.y + 18) {
                    
                    enemy.health--;
                    if (enemy.health <= 0) {
                        // Enemy destroyed
                        createExplosion(new Point(enemy.position.x + 10, enemy.position.y + 10), Color.RED);
                        enemyIt.remove();
                        
                        // Score and combo
                        combo++;
                        comboTimeout = COMBO_TIME_LIMIT;
                        if (combo % 5 == 0) {
                            comboMultiplier = combo / 5;
                            createExplosion(new Point(getWidth()/2, 50), Color.YELLOW);
                        }
                        
                        int points = (enemy.type + 1) * 10 * comboMultiplier;
                        score += points;
                        if (score > highScore) highScore = score;
                        
                        // Chance to spawn power-up
                        if (Math.random() < 0.2) {
                            int powerUpType = (int)(Math.random() * 4);
                            powerUps.add(new PowerUp(new Point(enemy.position.x, enemy.position.y), powerUpType));
                        }
                    }
                    
                    if (weaponLevel < 3) { // Laser pierces through enemies
                        missileIt.remove();
                        missileUsed = true;
                    }
                    break;
                }
            }
        }

        // Player-Enemy collisions
        if (!isInvulnerable && !shieldActive) {
            Iterator<Enemy> enemyIt = enemies.iterator();
            while (enemyIt.hasNext()) {
                Enemy enemy = enemyIt.next();
                if (enemy.position.y + 20 >= PLAYER_Y && 
                    enemy.position.x + 20 >= playerX && enemy.position.x <= playerX + PLAYER_WIDTH) {
                    
                    handlePlayerHit();
                    if (enemy.type != 3) {
                        createExplosion(new Point(enemy.position.x + 10, enemy.position.y + 10), Color.ORANGE);
                        enemyIt.remove();
                    }
                    break;
                }
            }
        }

        // Player-PowerUp collisions
        Iterator<PowerUp> powerUpIt = powerUps.iterator();
        while (powerUpIt.hasNext()) {
            PowerUp pu = powerUpIt.next();
            if (pu.position.y + 15 >= PLAYER_Y && 
                pu.position.x + 15 >= playerX && pu.position.x <= playerX + PLAYER_WIDTH) {
                
                applyPowerUp(pu.type);
                powerUpIt.remove();
                playBeep(880, 100); // Power-up sound
            }
        }
    }

    private void handlePlayerHit() {
        lives--;
        isInvulnerable = true;
        invulnerabilityTimer = 60;
        combo = 0;
        comboMultiplier = 1;
        
        // Screen shake effect
        final int originalX = playerX;
        playerX += 15;
        Timer shakeTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerX = originalX;
                ((Timer)e.getSource()).stop();
            }
        });
        shakeTimer.setRepeats(false);
        shakeTimer.start();
        
        playBeep(220, 200); // Hit sound
    }

    private void applyPowerUp(int type) {
        switch (type) {
            case 0: // Rapid Fire
                rapidFireActive = true;
                rapidFireTimer = 300; // 15 seconds
                break;
            case 1: // Shield
                shieldActive = true;
                shieldTimer = 400; // 20 seconds
                break;
            case 2: // Multi-shot
                multiShotActive = true;
                multiShotTimer = 200; // 10 seconds
                weaponLevel = Math.min(weaponLevel + 1, MAX_WEAPON_LEVEL);
                break;
            case 3: // Life
                lives = Math.min(lives + 1, 5);
                break;
        }
    }

    private void createExplosion(Point position, Color color) {
        for (int i = 0; i < 12; i++) {
            particles.add(new Particle(position, color));
        }
    }

    private void endGame() {
        gameState = GameState.GAME_OVER;
        timer.stop();
        saveHighScore();
    }

    private void restartGame() {
        playerX = getWidth() / 2 - PLAYER_WIDTH / 2;
        missiles.clear();
        enemies.clear();
        powerUps.clear();
        particles.clear();
        lives = 3;
        score = 0;
        level = 1;
        currentWave = 1;
        weaponLevel = 1;
        autoMissileCooldown = 0;
        manualMissileCooldown = 0;
        rapidFireActive = false;
        multiShotActive = false;
        shieldActive = false;
        isInvulnerable = false;
        combo = 0;
        comboMultiplier = 1;
        currency = 0;
        gameState = GameState.PLAYING;
        timer.start();
    }

    // Audio system using Java built-in beep
    private void playBeep(int frequency, int duration) {
        // Simple beep implementation
        try {
            java.awt.Toolkit.getDefaultToolkit().beep();
        } catch (Exception e) {
            // Silent fail
        }
    }

    // Save/load system
    private void saveHighScore() {
        try (PrintWriter out = new PrintWriter("highscore.txt")) {
            out.println(highScore);
        } catch (FileNotFoundException e) {
            // Ignore
        }
    }

    private void loadHighScore() {
        try (BufferedReader in = new BufferedReader(new FileReader("highscore.txt"))) {
            highScore = Integer.parseInt(in.readLine());
        } catch (Exception e) {
            highScore = 0;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        switch (gameState) {
            case MENU:
                if (key == KeyEvent.VK_ENTER) {
                    gameState = GameState.PLAYING;
                    timer.start();
                    startNextWave();
                }
                break;
                
            case PLAYING:
                if (key == KeyEvent.VK_LEFT) leftPressed = true;
                if (key == KeyEvent.VK_RIGHT) rightPressed = true;
                if (key == KeyEvent.VK_SPACE) spacePressed = true;
                if (key == KeyEvent.VK_P) {
                    gameState = GameState.PAUSED;
                    timer.stop();
                }
                break;
                
            case PAUSED:
                if (key == KeyEvent.VK_P) {
                    gameState = GameState.PLAYING;
                    timer.start();
                }
                break;
                
            case GAME_OVER:
                if (key == KeyEvent.VK_ENTER) {
                    restartGame();
                }
                break;
                
            case SHOP:
                handleShopInput(key);
                break;
        }
    }

    private void handleShopInput(int key) {
        switch (key) {
            case KeyEvent.VK_1: // Upgrade weapon
                if (currency >= 50 && weaponLevel < MAX_WEAPON_LEVEL) {
                    weaponLevel++;
                    currency -= 50;
                }
                break;
            case KeyEvent.VK_2: // Buy life
                if (currency >= 30 && lives < 5) {
                    lives++;
                    currency -= 30;
                }
                break;
            case KeyEvent.VK_3: // Buy rapid fire
                if (currency >= 40) {
                    rapidFireActive = true;
                    rapidFireTimer = 300;
                    currency -= 40;
                }
                break;
            case KeyEvent.VK_ENTER: // Start next wave
                gameState = GameState.PLAYING;
                startNextWave();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) leftPressed = false;
        if (key == KeyEvent.VK_RIGHT) rightPressed = false;
        if (key == KeyEvent.VK_SPACE) spacePressed = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        new PlaneDefenseEnhanced();
    }
}